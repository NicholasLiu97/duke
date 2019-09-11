import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Ui class deals with interacting with the user, receiving input
 * from the user and output messages to the user
 */
public class Ui {

    /**
     * greets the user
     */
    public void greet() {
        printLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }

    /**
     * says goodbye to the user
     */
    public void goodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * scans the command input by the user
     * @return a string that contains the words typed by the user
     */
    public String readCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * prints a horizontal line to separate lines
     */
    public void printLine() {
        System.out.println("_______________________________________________________");
    }

    /**
     * prints this message when a task is added to the task list in Duke
     * @param task Task object which was added to the task list
     * @param size the number of tasks in the task list
     */
    public void printAddTask(Task task, int size) {
        System.out.println("Got it. I've added this task: ");
        System.out.println("  " + task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * prints this message when a task is deleted from the task list in Duke
     * @param task Task object which was deleted from the task lsit
     * @param size the number of tasks in the task list
     */
    public void printDeleteTask(Task task, int size) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println("  " + task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * prints this message when a task is marked as done
     * @param task Task object which was marked as done
     */
    public void printDone(Task task) {
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println("  " + task.toString());
    }

    /**
     * prints this message when looks for keywords he input
     * @param searchList the array list of Task objects that contain the keywords
     * @throws DukeException if none of the task descriptions matches the keywords
     */
    public void printSearch(ArrayList<Task> searchList) throws DukeException {
        if (searchList.isEmpty()) {
            throw new DukeException(" ☹ OOPS!!! No matches found. ");
        }
        System.out.println("Here are the matching tasks in your list: ");
        for (int i = 0; i < searchList.size(); i ++) {
            System.out.println(i+1 + "." + searchList.get(i).toString());
        }
    }

    /**
     * prints the entire list of tasks
     * @param list list of tasks stored in Duke
     */
    public void printList(ArrayList<Task> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i).toString());
        }
    }

    /**
     * prints this message when an error is encountered
     * @param DE the exception containing the message
     */
    public void showError(DukeException DE) {
        System.out.println(DE.getMessage());
    }
}
