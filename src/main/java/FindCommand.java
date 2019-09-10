import java.util.ArrayList;

public class FindCommand extends Command{

    protected String description;

    public FindCommand(String finalCommand) {
        this.description = finalCommand;
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        ArrayList<Task> searchList = new ArrayList<>();
        searchList = task.find(this.description);
        try {
            ui.printSearch(searchList);
        } catch (DukeException DE) {
            ui.showError(DE);
        }
    }
}
