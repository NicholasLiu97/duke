import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private static ArrayList<Task> list = new ArrayList<>();

    private static void showList() {
        for (int i = 0; i < list.size(); i++) {
            Task currTask = list.get(i);
            System.out.println((i+1) + ".[" + currTask.getStatusIcon() + "] " + currTask.description);
        }
    }
    private static void addToList(String cmd) {
        Task newTask = new Task(cmd);
        list.add(newTask);
        System.out.println("added: " + cmd);
    }

    private static void markAsDone(String taskNumber) {
        int taskNum = Integer.parseInt(taskNumber);
        Task currTask = list.get(taskNum - 1);
        currTask.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(" [" + currTask.getStatusIcon() + "] " + currTask.description);
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
                if (words[0].equals("done")) { //done with a task
                    markAsDone(words[1]);
                } else { //adding task to list
                    addToList(cmd);
                }
            }
        }
    }
}

