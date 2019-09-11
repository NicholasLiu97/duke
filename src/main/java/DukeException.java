/**
 * Exception handler for duke to print custom messages to show
 * what went wrong when an exception is encountered
 */
public class DukeException extends Exception{
    public DukeException(String message) {
        super(message);
    }
}
