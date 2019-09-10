import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    public void showLoadingError() {
    }

    public void greet() {
        printLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }

    public void goodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public String readCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printLine() {
        System.out.println("_______________________________________________________");
    }

    public void printAddTask(Task task, int size) {
        System.out.println("Got it. I've added this task: ");
        System.out.println("  " + task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void printDeleteTask(Task task, int size) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println("  " + task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void printDone(Task task) {
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println("  " + task.toString());
    }

    public void printSearch(ArrayList<Task> searchList) throws DukeException {
        if (searchList.isEmpty()) {
            throw new DukeException(" ☹ OOPS!!! No matches found. ");
        }
        System.out.println("Here are the matching tasks in your list: ");
        for (int i = 0; i < searchList.size(); i ++) {
            System.out.println(i+1 + "." + searchList.get(i).toString());
        }
    }

    public void printList(ArrayList<Task> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i).toString());
        }
    }

    public void showError(DukeException DE) {
        System.out.println(DE.getMessage());
    }
}
