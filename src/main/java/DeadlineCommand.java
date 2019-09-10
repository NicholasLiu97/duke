public class DeadlineCommand extends Command {

    protected String description;
    protected String by;

    public DeadlineCommand(String finalCommand) throws DukeException {
        String[] deadlineWords = finalCommand.split(" /by ");
        if (deadlineWords.length != 2) {
            throw new DukeException(" ☹ OOPS!!! Please use the format task /by dd/MM/yyyy HHmm");
        }

        String[] temp = deadlineWords[1].split("/");
        if (temp.length != 3) {
            throw new DukeException(" ☹ OOPS!!! Please change date format to dd/MM/yyyy HHmm");
        }
        this.description = deadlineWords[0];
        this.by = deadlineWords[1];
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        Deadline newDeadline = new Deadline(this.description, this.by);
        task.addTask(newDeadline);
        ui.printAddTask(newDeadline, task.getSize());
    }
}
