import java.util.LinkedHashMap;

public class taskList{
    LinkedHashMap<String, Task> taskList;

    public taskList(){
        taskList = new LinkedHashMap<>();
    }

    public String displayTasks(){
        StringBuilder displayString = new StringBuilder();
        int index = 1;
        for (String key : taskList.keySet()){
            displayString.append("Task ").append(index).append(": ").append(taskList.get(key).getTaskName()).append("\n");
            index++;
        }
        return displayString.toString();
    }

    public void addTask(Task task){
        taskList.put(task.getTaskName(), task);
    }

    public void removeTask(Task task){
        taskList.remove(task.getTaskName());
    }
}
