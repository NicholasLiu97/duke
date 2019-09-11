import java.util.ArrayList;

/**
 * The TaskList class contains the methods can can be executed on the task list
 */
public class TaskList {

    protected ArrayList<Task> list;

    /**
     * Contructor for TaskList
     * @param list an array list of Task objects
     */
    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    /**
     * adds a task to the TaskList
     * @param task the task to be added to the task list
     */
    public void addTask(Task task) {
        this.list.add(task);
    }

    /**
     * Mark a task as done
     * @param taskIndex the index of the task to be marked as done in the array
     *                  list of Task objects
     */
    public void markAsDone(int taskIndex) {
        Task currTask = this.list.get(taskIndex);
        currTask.isDone = true;
    }

    /**
     * Delete a task from the task list
     * @param taskIndex the index of the task to be deleted in the array list of
     *                  Task objects
     */
    public void deleteTask(int taskIndex) {
        Task taskToDelete = this.list.get(taskIndex);
        this.list.remove(taskToDelete);
    }

    /**
     * finds the tasks that contain the keyword
     * @param description the keywords that the user wants to search for
     * @return an array list of Task objects
     */
    public ArrayList<Task> find(String description) {
        ArrayList<Task> searchList = new ArrayList<>();
        for (Task T : list) {
            if (T.toString().contains(description)) {
                searchList.add(T);
            }
        }

        return searchList;
    }

    /**
     * returns the list of tasks
     * @return an array list which contains all the Task objects
     */
    public ArrayList<Task> getTasks() {
        return this.list;
    }

    /**
     * gets the size of the task list
     * @return an integer equal to the number of tasks in the task list
     */
    public int getSize() {
        return list.size();
    }
}
