import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private File taskFile;
    public Storage(String filePath) throws DukeException {
        this.taskFile = new File(filePath);
        if (!this.taskFile.exists()) {
            throw new DukeException("☹ OOPS!!! Your file can't be found.");
        }
    }

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
