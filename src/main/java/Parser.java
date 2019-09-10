public class Parser {
    public static Command parse(String command) throws DukeException {
        command = command.trim();

        String[] words = command.split(" "); //get individual words out
        String firstWord = words[0];
        String instr = firstWord.toLowerCase(); //convert all letters of the instruction to lower case
        String finalCommand = command.replaceAll(firstWord + " ", "");
        switch (instr) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "todo":
                if (words.length == 1) {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
                return new TodoCommand(finalCommand);
            case "event":
                if (words.length == 1) {
                    throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
                }
                return new EventCommand(finalCommand);
            case "deadline":
                if (words.length == 1) {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                }
                return new DeadlineCommand(finalCommand);
            case "done":
                if (words.length == 1) {
                    throw new DukeException("☹ OOPS!!! Please specify which task to complete. ");
                }
                return new DoneCommand(finalCommand);
            case "delete":
                if (words.length == 1) {
                    throw new DukeException("☹ OOPS!!! Please specify which task to remove. ");
                }
                return new DeleteCommand(finalCommand);
            case "find":
                if (words.length == 1) {
                    throw new DukeException("☹ OOPS!!! The description of a search cannot be empty.");
                }
                return new FindCommand(finalCommand);
            default:
                throw new DukeException(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
