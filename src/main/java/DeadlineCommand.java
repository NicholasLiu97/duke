/**
 * Subclass of command which contains the instructions for Duke to execute
 * on a deadline command
 */
public class DeadlineCommand extends Command {

    protected String description;
    protected String by;

    /**
     * Constructor for DeadlineCommand
     * @param finalCommand contains the entire line input by the user for deadline
     * @throws DukeException if the command is not in the format deadline "something" /by "date"
     */
    public DeadlineCommand(String finalCommand) throws DukeException {
        String[] deadlineWords = finalCommand.split(" /by ");
        if (deadlineWords.length != 2) {
            throw new DukeException(" ☹ OOPS!!! Please use the format task /by dd/MM/yyyy HHmm");
        }

        String[] temp = deadlineWords[1].split("/"); //split the day, month and year + time
        if (temp.length != 3) { // if date format is not in dd/MM/yyyy HHmm
            throw new DukeException(" ☹ OOPS!!! Please change date format to dd/MM/yyyy HHmm");
        }
        this.description = deadlineWords[0];
        this.by = deadlineWords[1];
    }

    /**
     * Override method that adds the deadline task into the TaskList and print a
     * statement to show the user what has been added to the task list
     * @param task contains the task list which the new deadline task will be added to
     * @param ui the ui of the program that prints messages and interacts with the
     *           user
     * @param storage Storage class to save the list of tasks back into the .txt file
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        Deadline newDeadline = new Deadline(this.description, this.by);
        task.addTask(newDeadline);
        ui.printAddTask(newDeadline, task.getSize());
    }
}
