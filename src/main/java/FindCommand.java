import java.util.ArrayList;

/**
 * subclass of Command which contains the instructions for Duke to execute
 * on a find command
 */
public class FindCommand extends Command{

    protected String description;

    /**
     * Constructor for FindCommand
     * @param finalCommand contains the entire line input by the user to be searched for
     */
    public FindCommand(String finalCommand) {
        this.description = finalCommand;
    }

    /**
     * Override method that finds the tasks that contain the words inut by the user
     * prints out the tasks with the relevant words
     * @param task contains the task list which is used for the search
     * @param ui the ui of the program that prints messages and interacts with the
     *           user
     * @param storage Storage class to save the list of tasks back into the .txt file
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        ArrayList<Task> searchList = new ArrayList<>();
        searchList = task.find(this.description); //add the tasks with the keywords into searchList
        try {
            ui.printSearch(searchList); //prints out the tasks that contain the keywords
        } catch (DukeException DE) {
            ui.showError(DE);
        }
    }
}
