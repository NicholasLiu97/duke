import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The storage class deals with loading tasks from the specified .txt file into
 * the TaskList class and save tasks back into the .txt file when the program
 * exits
 */

public class Storage {

    private File taskFile;

    /**
     * Constructor for Storage
     * @param filePath specifies the file path of the file to be read
     * @throws DukeException if file does not exist
     */
    public Storage(String filePath) throws DukeException {
        this.taskFile = new File(filePath);
        if (!this.taskFile.exists()) {
            throw new DukeException("☹ OOPS!!! Your file can't be found.");
        }
    }

    /**
     * reads the contents from the taskFile, classifies them into deadline, to do
     * or event, and adds them to an array list
     * @return An array list of the Task class which contains all the tasks read
     * from the file
     * @throws DukeException if file does not exist
     */
    public ArrayList<Task> getFileContents() throws DukeException {
        ArrayList<Task> list = new ArrayList<>();

        try {
            Scanner fileScanner = new Scanner(this.taskFile);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] words = line.split(" \\| ");
//                System.out.println(line);

//            if (!(words[1].equals("0") || words[1].equals("1"))) { //if the task completion is neither 0 or 1
//                throw new DukeException("☹ OOPS!!! The task can only be marked with \"0\" or \"1\"");
//            }

                if (words[0].equals("T")) { //Todo
                    Todo newTodo = new Todo(words[2]);
                    if (words[1].equals("1")) {
                        newTodo.isDone = true;
                    }
                    list.add(newTodo);
                } else if (words[0].equals("D")) { //deadline
                    Deadline newDeadline = new Deadline(words[2], words[3]);
                    if (words[1].equals("1")) {
                        newDeadline.isDone = true;
                    }
                    list.add(newDeadline);
                } else { //event
                    Event newEvent = new Event(words[2], words[3]);
                    if (words[1].equals("1")) {
                        newEvent.isDone = true;
                    }
                    list.add(newEvent);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException FNFE) {
            throw new DukeException("☹ OOPS!!! Your file can't be found.");
        }
        return list;
    }

    /**
     * reads the list from the TaskList class and saves the tasks into the specified
     * .txt file
     * @param task contains the list of tasks that needs to be saved into the .txt
     * file
     * @throws DukeException
     */
    public void writeFileContents(TaskList task) throws DukeException {
        try {
            FileWriter fw = new FileWriter(taskFile);
            for (int i = 0; i < task.getSize(); i++) {
                fw.write(task.list.get(i).writeToFile() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException IOE) {
            throw new DukeException("☹ OOPS!!! Your file can't be found.");
        }
    }
}
