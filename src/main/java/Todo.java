/**
 * subclass of Task that represents a to-do
 */
public class Todo extends Task {

    /**
     * Constructor for Todo
     * @param description the description as entered by the user
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * override method that converts the task from the TaskList into user readable format
     * @return A string that contains the task, the checkbox and the deadline
     */
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * override method that converts the task back into the format stored in the file
     * @return a string that contains the task which would be stored in the .txt file
     */
    public String writeToFile() {
        return "T | " + super.writeToFile();
    }
}
