public class EventCommand extends Command {

    protected String description;
    protected String at;

    public EventCommand(String finalCommand) throws DukeException {
        String[] eventWords = finalCommand.split("/at");
        if (eventWords.length != 2) {
            throw new DukeException(" ☹ OOPS!!! Please use the format event /at place");
        }
        this.description = eventWords[0];
        this.at = eventWords[1];
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        Event newEvent = new Event(this.description, this.at);
        task.addTask(newEvent);
        ui.printAddTask(newEvent, task.getSize());
    }
}
