import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private static ArrayList<Task> list = new ArrayList<>();

    private static void showList() {
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

        if (instr.equals("deadline")) {
            String[] deadlineWords = finalCmd.split(" /by ");
            Deadline newDeadline = new Deadline(deadlineWords[0], deadlineWords[1]);
            list.add(newDeadline);
            System.out.println("Got it. I've added this task:");
            System.out.println("    " + newDeadline.toString());
            System.out.println("Now you have " + list.size() + " tasks in the list.");
        } else if (instr.equals("event")) {
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
    }

    private static void markAsDone(String taskNumber) {
        int taskNum = Integer.parseInt(taskNumber);
        Task currTask = list.get(taskNum - 1);
        currTask.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(" [" + currTask.getStatusIcon() + "] " + currTask.description);
    }

    private static Boolean isValidInput(String[] words) {
        if (words.length == 1) {
            if (words[0].equals("todo")) {
                System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
            } else if (words[0].equals("deadline")) {
                System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
            } else if (words[0].equals("event")){
                System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
            } else {
                System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
            return false;
        } else {
            if (words[0].equals("done")) {
                return true;
            } else if (!words[0].equals("todo") && !words[0].equals("deadline") && !words[0].equals("event")) {
                System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
/*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
 */
        String cmd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        while(true) {
            cmd = scanner.nextLine();
            if (cmd.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
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
                } else { //adding task to list
                    addToList(cmd);
                }
            }
        }
    }
}

