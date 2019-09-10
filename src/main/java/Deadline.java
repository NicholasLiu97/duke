import java.util.Date;
import java.text.SimpleDateFormat;

public class Deadline extends Task {

    protected String by;
    protected String byWords;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;

        DateFormatter deadlineDate =  new DateFormatter(this.by);
        try {
            this.byWords = deadlineDate.toWords();
        } catch (DukeException DE) {
            Ui ui = new Ui();
            ui.showError(DE);
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.byWords + ")";
    }

    @Override
    public String writeToFile() {
        return "D | " + super.writeToFile() + " | " + this.by;
    }
}
