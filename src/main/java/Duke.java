/**
 * The Duke program implements a task manager which allows a user to track
 * to dos, deadlines and events and save the list of these tasks on the local machine.
 * The main functions include adding tasks to the task manager, marking the completion
 * of a task and removing of tasks from the task manager.
 *
 * @author Nicholas Liu
 * @version  1.0
 * @since 2019-09-01
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        try {
            // finds the file that contains the task list
            storage = new Storage(filePath);
            // loads the task list into the TaskList class
            tasks = new TaskList(storage.getFileContents());
        } catch (DukeException DE) {
            ui.showError(DE);
        }
    }

    public void run() {
        ui.greet();
        boolean isExit = false;
        // this block of code will run as long as input is not "bye"
        while (!isExit) {
            try {
                String command = ui.readCommand();
                ui.printLine(); // print a horizontal line
                Command c = Parser.parse(command); // recognise what type of command is given based on input
                c.execute(tasks, ui, storage); //execute the command
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
        new Duke(filePath).run(); //run the Duke program
    }
}
