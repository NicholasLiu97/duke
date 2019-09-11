/**
 * subclass of Command which contains the instructions for Duke to execute
 * on an exit command
 */
public class ExitCommand extends Command {

    /**
     * Override method that saves the list of tasks in Duke back into the .txt file
     * the user what has been added to the task list
     * @param task contains the task list which will be saved into the .txt file
     * @param ui the ui of the program that prints messages and interacts with the
     *           user
     * @param storage Storage class to save the list of tasks back into the .txt file
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        this.isExit = true;
        ui.goodbye();
        try {
            storage.writeFileContents(task);
        } catch (DukeException DE) {
            ui.showError(DE);
        }
    }
}
