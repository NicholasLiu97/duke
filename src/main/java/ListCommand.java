import java.util.ArrayList;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        ArrayList<Task> allTasks = task.getTasks();
        ui.printList(allTasks);
    }
}
