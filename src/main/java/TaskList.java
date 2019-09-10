import java.util.ArrayList;

public class TaskList {

    protected ArrayList<Task> list;

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public void addTask(Task task) {
        this.list.add(task);
    }

    public void markAsDone(int taskIndex) {
        Task currTask = this.list.get(taskIndex);
        currTask.isDone = true;
    }

    public void deleteTask(int taskIndex) {
        Task taskToDelete = this.list.get(taskIndex);
        this.list.remove(taskToDelete);
    }

    public ArrayList<Task> find(String description) {
        ArrayList<Task> searchList = new ArrayList<>();
        for (Task T : list) {
            if (T.toString().contains(description)) {
                searchList.add(T);
            }
        }

        return searchList;
    }

    public ArrayList<Task> getTasks() {
        return this.list;
    }

    public int getSize() {
        return list.size();
    }
}
