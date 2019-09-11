/**
 * subclass of task that represents deadline
 */
public class Deadline extends Task {

    protected String by;
    protected String byWords;

    /**
     * contructor for Deadline
     * @param description the description of the deadline task
     * @param by date and time which the task needs to be completed by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;

        DateFormatter deadlineDate =  new DateFormatter(this.by);
        try {
            this.byWords = deadlineDate.toWords(); //convert date into readable format which Duke understands
        } catch (DukeException DE) {
            Ui ui = new Ui();
            ui.showError(DE);
        }
    }

    /**
     * override method that converts the task from the TaskList into user readable format
     * @return A string that contains the task, the checkbox and the deadline
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.byWords + ")";
    }

    /**
     * override method that converts the task back into the format stored in the file
     * @return a string that contains the task which would be stored in the .txt file
     */
    @Override
    public String writeToFile() {
        return "D | " + super.writeToFile() + " | " + this.by;
    }
}
