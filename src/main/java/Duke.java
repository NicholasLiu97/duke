import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private static void addToList(String cmd, ArrayList<String> list) {
        list.add(cmd);
        System.out.println("added: " + cmd);
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

        ArrayList<String> list = new ArrayList<>();
        while(true) {
            cmd = scanner.nextLine();
            if (cmd.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (cmd.equals("list")) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i));
                }
            } else {
                addToList(cmd, list);
            }
        }
    }


}

