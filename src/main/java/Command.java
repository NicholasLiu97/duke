/**
 * The command class is an abstract class that is the superclass of
 * all the other commands.
 */
public abstract class Command {

    protected boolean isExit = false;
    public Command() {

    }

    /**
     * execute the command input by the user
     * @param tasks provides the list of tasks for the command to make changes to
     * @param ui the ui of the program that prints messages and interacts with the
     *           user
     * @param storage Storage class to save the list of tasks back into the
     *                specified file
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }

    /**
     * returns the boolean value of isExit
     * @return true if isExit is true and false if isExit is false
     */
    public boolean isExit() {
        return this.isExit;
    }
}
