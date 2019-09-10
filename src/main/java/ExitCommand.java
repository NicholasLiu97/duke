import java.io.IOException;

public class ExitCommand extends Command {

    //    public ExitCommand() {
//        this.isExit = true;
//    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        this.isExit = true;
        ui.goodbye();
        try {
            storage.writeFileContents(task);
        } catch (DukeException DE) {
            ui.showError(DE);
        }

    }
}
