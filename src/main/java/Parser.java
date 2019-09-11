/**
 * The Parser class is used to make sense of the input entered by the user
 */
public class Parser {

    /**
     * understand the input entered by the user and categorise it into the appropriate command
     * @param command the entire line input by the user
     * @return an object of type Command
     * @throws DukeException if the input of the user is incomplete or inaccurate
     */
    public static Command parse(String command) throws DukeException {
        command = command.trim();

        String[] words = command.split(" "); //get individual words out
        String firstWord = words[0];
        String instr = firstWord.toLowerCase(); //convert all letters of the instruction to lower case
        //remove the first word of the command so that only the description is left
        String finalCommand = command.replaceAll(firstWord + " ", "");
        switch (instr) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "todo":
                if (words.length == 1) { //if only the word "todo" is present
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
                return new TodoCommand(finalCommand);
            case "event":
                if (words.length == 1) { //if only the word "event" is present
                    throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
                }
                return new EventCommand(finalCommand);
            case "deadline":
                if (words.length == 1) { //if only the word "deadline" is present
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                }
                return new DeadlineCommand(finalCommand);
            case "done":
                if (words.length == 1) { //if only the word "done" is present
                    throw new DukeException("☹ OOPS!!! Please specify which task to complete. ");
                }
                return new DoneCommand(finalCommand);
            case "delete":
                if (words.length == 1) { //if only the word "delete" is present
                    throw new DukeException("☹ OOPS!!! Please specify which task to remove. ");
                }
                return new DeleteCommand(finalCommand);
            case "find":
                if (words.length == 1) { //if only the word "find" is present
                    throw new DukeException("☹ OOPS!!! The description of a search cannot be empty.");
                }
                return new FindCommand(finalCommand);
            default:
                // if input by the user does not match any of the recognised command
                throw new DukeException(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
