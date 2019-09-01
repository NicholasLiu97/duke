public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "\u2713";
        }
        return "\u2718";
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String writeToFile() {
        String checkBox = "0";
        if (this.isDone) {
            checkBox = "1";
        }

        return checkBox + " | " + this.description;
    }

}
