/**
 * The task class is the superclass of all other commands and is used to
 * store the description of the task
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for Task
     * @param description the description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * show if the task is completed or incomplete
     * @return a tick if the task is completed and a cross if the task is incomplete
     */
    public String getStatusIcon() {
        if (isDone) {
            return "\u2713";
        }
        return "\u2718";
    }

    /**
     * converts the task obtained from the TaskList class into a string which can be printed
     * out and can be easily read by the user
     * @return a string that contains the status icon and description of the task
     */
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * converts the task from the TaskList class into a string which fits the format of the
     * tasks in the .txt file
     * @return a string that contains a check mark of "1" or "0" and the description of the task
     */
    public String writeToFile() {
        String checkBox = "0";
        if (this.isDone) {
            checkBox = "1";
        }
        return checkBox + " | " + this.description;
    }
}
