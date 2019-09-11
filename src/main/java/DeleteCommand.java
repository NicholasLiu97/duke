/**
 *  Subclass of command which contains the instructions for duke to execute
 *  on a delete command
 */
public class DeleteCommand extends Command {

    protected int taskIndex;

    /**
     * constructor for DeleteCommand
     * @param finalCommand Contains the task number that is about to be deleted
     * @throws DukeException if the task number is not an integer
     */
    public DeleteCommand(String finalCommand) throws DukeException {
        try {
            this.taskIndex = Integer.parseInt(finalCommand) - 1;
        } catch (NumberFormatException NFE) {
            throw new DukeException(" ☹ OOPS!!! Task number needs to be an integer. ");
        }
    }

    /**
     * Override method that adds the deletes the specified task from the list and print a
     * statement to show the user what has been deleted from the task list
     * @param task contains the task list which the task will be deleted from
     * @param ui the ui of the program that prints messages and interacts with the
     *           user
     * @param storage Storage class to save the list of tasks back into the .txt file
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        ui.printDeleteTask(task.list.get(taskIndex), task.getSize()-1);
        task.deleteTask(this.taskIndex);

    }
}
