/**
 *  Subclass of command which contains the instructions for duke to execute
 *  on a done command
 */
public class DoneCommand extends Command {

    protected int taskIndex;

    /**
     * constructor for DoneCommand
     * @param finalCommand Contains the task number that is marked as done by the user
     * @throws DukeException if the task number is not an integer
     */
    public DoneCommand(String finalCommand) throws DukeException {
        try {
            this.taskIndex = Integer.parseInt(finalCommand) - 1;
        } catch (NumberFormatException NFE) {
            throw new DukeException(" ☹ OOPS!!! Task number needs to be an integer. ");
        }
    }

    /**
     * Override method that marks the specified task as done in the list and print a
     * statement to show the user what has been marked as done
     * @param task contains the task list which the done command will be executed on
     * @param ui the ui of the program that prints messages and interacts with the
     *           user
     * @param storage Storage class to save the list of tasks back into the .txt file
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        task.markAsDone(this.taskIndex);
        ui.printDone(task.list.get(this.taskIndex));
    }
}
