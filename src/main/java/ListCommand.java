import java.util.ArrayList;

/**
 * subclass of Command which contains the instructions for Duke to execute
 * on a list command
 */
public class ListCommand extends Command {

    /**
     * Override method that prints out the list of tasks stored in Duke
     * @param task contains the task list which would be printed
     * @param ui the ui of the program that prints messages and interacts with the
     *           user
     * @param storage Storage class to save the list of tasks back into the .txt file
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        ArrayList<Task> allTasks = task.getTasks(); //retrieves the list of tasks from TaskList class
        ui.printList(allTasks);
    }
}
