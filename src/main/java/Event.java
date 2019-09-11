/**
 * subclass of Task that represents event
 */
public class Event extends Task {

    protected String at;

    /**
     * Constructor for Event
     * @param description the description of the event
     * @param at place where the event is held
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * override method that converts the task from the TaskList into user readable format
     * @return A string that contains the task, the checkbox and the deadline
     */
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.at + ")";
    }

    /**
     * override method that converts the task back into the format stored in the file
     * @return a string that contains the task which would be stored in the .txt file
     */
    public String writeToFile() {
        return "E | " + super.writeToFile() + " | " + this.at;
    }
}
