public class TodoCommand extends Command {

    protected String description;

    public TodoCommand(String finalCommand) {
        this.description = finalCommand;
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        Todo newTodo = new Todo(this.description);
        task.addTask(newTodo);
        ui.printAddTask(newTodo, task.getSize());
    }
}
