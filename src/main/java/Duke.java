
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();

        try {
            storage = new Storage(filePath);
            tasks = new TaskList(storage.getFileContents());
        } catch (DukeException DE) {
            ui.showError(DE);
        }
    }

    public void run() {
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            try {
                String command = ui.readCommand();
                ui.printLine();
                Command c = Parser.parse(command);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException DE) {
                ui.showError(DE);
            } finally {
                ui.printLine();
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/DukeTasks.txt";
        new Duke(filePath).run();
    }
}
