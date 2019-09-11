/**
 * Subclass of command which contains the instructions for Duke to execute
 * on an event command
 */
public class EventCommand extends Command {

    protected String description;
    protected String at;

    /**
     * Constructor for EventCommand
     * @param finalCommand contains the entire line input by the user for event
     * @throws DukeException if the command is not in the format event "something" /at "place"
     */
    public EventCommand(String finalCommand) throws DukeException {
        String[] eventWords = finalCommand.split("/at");
        if (eventWords.length != 2) {
            throw new DukeException(" ☹ OOPS!!! Please use the format event /at place");
        }
        this.description = eventWords[0];
        this.at = eventWords[1];
    }

    /**
     * Override method that adds event into the TaskList and print a statement to show
     * the user what has been added to the task list
     * @param task contains the task list which the new event will be added to
     * @param ui the ui of the program that prints messages and interacts with the
     *           user
     * @param storage Storage class to save the list of tasks back into the .txt file
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        Event newEvent = new Event(this.description, this.at);
        task.addTask(newEvent);
        ui.printAddTask(newEvent, task.getSize());
    }
}
