public class DeleteCommand extends Command {

    protected int taskIndex;

    public DeleteCommand(String finalCommand) throws DukeException {
        try {
            this.taskIndex = Integer.parseInt(finalCommand) - 1;
        } catch (NumberFormatException NFE) {
            throw new DukeException(" ☹ OOPS!!! Task number needs to be an integer. ");
        }
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        ui.printDeleteTask(task.list.get(taskIndex), task.getSize()-1);
        task.deleteTask(this.taskIndex);

    }
}
