public class DoneCommand extends Command {

    protected int taskIndex;

    public DoneCommand(String finalCommand) throws DukeException {
        try {
            this.taskIndex = Integer.parseInt(finalCommand) - 1;
        } catch (NumberFormatException NFE) {
            throw new DukeException(" ☹ OOPS!!! Task number needs to be an integer. ");
        }
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        task.markAsDone(this.taskIndex);
        ui.printDone(task.list.get(this.taskIndex));
    }
}
