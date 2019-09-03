import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Duke {

    private static ArrayList<Task> list = new ArrayList<>();
    private static final String DATE_FORMAT = "dd/MM/yyyy HHmm";

    private static void showList() {
        System.out.println("number of tasks = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            Task currTask = list.get(i);
//            System.out.println((i+1) + ".[" + currTask.getStatusIcon() + "] " + currTask.description);
            System.out.println((i+1) + "." + currTask.toString());
        }
    }

    private static void addToList(String cmd) {
        String[] words = cmd.split(" ");
        String instr = words[0];
        String toReplace = instr + " ";
        String finalCmd = cmd.replaceAll(toReplace, "");
        Date date;

        try {
            if (instr.equals("deadline")) {
                if (!finalCmd.contains("/by")) {
                    throw new DukeException("Please use /by to specify the deadline");
                }

                String[] deadlineWords = finalCmd.split(" /by ");
//                date = new SimpleDateFormat(DATE_FORMAT).parse(deadlineWords[1]);
                try {
                    Deadline newDeadline = new Deadline(deadlineWords[0], deadlineWords[1]);
                    //                Deadline newDeadline = new Deadline(deadlineWords[0], date);
                    list.add(newDeadline);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("    " + newDeadline.toString());
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                } catch (Exception e) {
                    throw new DukeException("Please ensure date is in dd/mm/yyyy HHmm format");
                }

            } else if (instr.equals("event")) {
                if (!finalCmd.contains("/at")) {
                    throw new DukeException("Please use /at to specify location of the event");
                }
                String[] eventWords = finalCmd.split(" /at ");
                Event newEvent = new Event(eventWords[0], eventWords[1]);
                list.add(newEvent);
                System.out.println("Got it. I've added this task:");
                System.out.println("    " + newEvent.toString());
                System.out.println("Now you have " + list.size() + " tasks in the list.");
            } else if (instr.equals("todo")) {
                Todo newToDo = new Todo(finalCmd);
                list.add(newToDo);
                System.out.println("Got it. I've added this task:");
                System.out.println("    " + newToDo.toString());
                System.out.println("Now you have " + list.size() + " tasks in the list.");
            } else {
                //default as Todo if inaccurate input
                Todo newToDo = new Todo(cmd);
                list.add(newToDo);
//            System.out.println("added: " + cmd);
                System.out.println("Got it. I've added this task:");
                System.out.println("    " + newToDo.toString());
                System.out.println("Now you have " + list.size() + " tasks in the list.");
            }
        } catch (DukeException DE) {
            System.out.println(DE.getMessage());
        }
    }

    private static void deleteFromList(String taskNumber) {
        int index = Integer.parseInt(taskNumber) - 1;
        Task taskToRemove = list.get(index);
        list.remove(taskToRemove);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + taskToRemove.toString());
        System.out.println("Now you have " + list.size() + " tasks in the list.");
    }

    private static void markAsDone(String taskNumber) {
        int taskNum = Integer.parseInt(taskNumber) - 1;
        Task currTask = list.get(taskNum);
        currTask.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(" [" + currTask.getStatusIcon() + "] " + currTask.description);
    }

    private static Boolean isValidInput(String[] words) {
        try {
            if (words.length == 1) { //only one word
                if (words[0].equals("todo")) {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                } else if (words[0].equals("deadline")) {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                } else if (words[0].equals("event")){
                    throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
                } else if (words[0].equals("delete")) {
                    throw new DukeException("☹ OOPS!!! Please specify which task to delete. ");
                } else if (words[0].equals("done")) {
                    throw new DukeException("☹ OOPS!!! Please specify which task to complete. ");
                } else {
                    throw new DukeException(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
//                return false;
            } else { //more than one word
//                try {
                    if (words[0].equals("done") || words[0].equals("delete")) {
                        return true;
                    } else if (!words[0].equals("todo") && !words[0].equals("deadline") && !words[0].equals("event")) {
                        throw new DukeException(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
//                        return false;
                    }
            }

        } catch (DukeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static ArrayList<Task> getFileContents(File taskFile) throws FileNotFoundException {

        ArrayList<Task> currList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(taskFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" \\| ");
//                System.out.println(line);

                if (words[0].equals("T")) { //Todo
                    Todo newTodo = new Todo(words[2]);
                    if (words[1].equals("1")) {
                        newTodo.isDone = true;
                    }
                    currList.add(newTodo);
                } else if (words[0].equals("D")) { //deadline
                    try {
//                        Date deadlineDate = new SimpleDateFormat(DATE_FORMAT).parse(words[3]);

                        Deadline newDeadline = new Deadline(words[2], words[3]);
                        if (words[1].equals("1")) {
                            newDeadline.isDone = true;
                        }
                        currList.add(newDeadline);
                    } catch (Exception e) {
                        System.out.println("Please change date to dd/mm/yyyy HHmm format, setting default date: " +
                                "23/9/2019 1900");
                        System.out.println("the date to change is " + words[3]);
                        //throw new DukeException("date format in file is incorrect");
                        Deadline newDeadline = new Deadline(words[2], "23/9/2019 1900");
                        System.out.println("entered exception block");
                        if (words[1].equals("1")) {
                            newDeadline.isDone = true;
                        }
                        currList.add(newDeadline);
                    }

                } else { //event
                    Event newEvent = new Event(words[2], words[3]);
                    if (words[1].equals("1")) {
                        newEvent.isDone = true;
                    }
                    currList.add(newEvent);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return currList;
    }

    private static void writeFileContents(File taskFile) {
        try {
            FileWriter fw = new FileWriter(taskFile);
            for (int i = 0; i < list.size(); i++) {
                fw.write(list.get(i).writeToFile() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException IOE) {
            System.out.println("Something went wrong " + IOE.getMessage());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
/*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
 */

        File taskFile = new File("src/main/java/DukeTasks.txt");

        list =  getFileContents(taskFile);

        String cmd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        while(true) {
            cmd = scanner.nextLine();
            if (cmd.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                writeFileContents(taskFile);
                break;
            } else if (cmd.equals("list")) {
                showList();

            } else { //either done a task or add a task
                String[] words = cmd.split(" ");
                String instr = words[0];
                if (!isValidInput(words)) {
                    continue;
                }

                if (instr.equals("done")) { //done with a task
                    markAsDone(words[1]);
                } else if (instr.equals("delete"))  {
                    try {
                        deleteFromList(words[1]);
                    } catch (Exception e) {
                        System.out.println("Please specify a number from 1 to " + list.size());
                    }

                } else { //adding task to list
                    addToList(cmd);
                }
            }
        }
    }
}

