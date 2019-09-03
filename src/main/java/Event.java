import java.util.Date;
import java.text.SimpleDateFormat;

public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.at + ")";
    }

    public String writeToFile() {
        return "E | " + super.writeToFile() + " | " + this.at;
    }
}
