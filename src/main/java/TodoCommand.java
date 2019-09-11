/**
 * Subclass of command which contains the instructions for Duke to execute
 * on a to-do command
 */
public class TodoCommand extends Command {

    protected String description;

    /**
     * Constructor for TodoCommand
     * @param finalCommand contains the entire line input by the user for deadline
     */
    public TodoCommand(String finalCommand) {
        this.description = finalCommand;
    }

    /**
     * Override method that adds the task into the TaskList and print a statement to
     * show the user what has been added to the task list
     * @param task contains the task list which the new task will be added to
     * @param ui the ui of the program that prints messages and interacts with the
     *           user
     * @param storage Storage class to save the list of tasks back into the .txt file
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        Todo newTodo = new Todo(this.description);
        task.addTask(newTodo);
        ui.printAddTask(newTodo, task.getSize());
    }
}
