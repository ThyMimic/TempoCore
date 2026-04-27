import java.io.*;
import java.util.LinkedHashMap;


public class taskList{
    private final LinkedHashMap<String, Task> taskList;
    private File file;

    public taskList(String listName){
        taskList = new LinkedHashMap<>();
        file = new File(listName);
        try{
            if (file.createNewFile()){
                System.out.println("File Successfully Created");
            }
            else{
                System.out.println("File Already Exists");
            }
        }
        catch (IOException error){
            System.out.println("Catastrophic Error: Unable to check file existence");
        }
    }

    public void saveList(){
        int index = 1;
        PrintWriter writer;
        try{
            writer = new PrintWriter(file);
            for (String key : taskList.keySet()){
                Task task = taskList.get(key);
                writer.println("Task " + index + ": " + task.getTaskName() + " /// "
                        + "Priority Ranking: " + task.calculatePriorityRanking()
                        + "\n");
                index++;
            }
            writer.close();
        }
        catch (IOException error){
            System.out.println("Catastrophic Error: Could not write to file");
        }
    }

    //TODO: Make parameterized method that only loads one task from text file
    public void loadList(){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException error){
            System.out.println("Catastrophic Error: Could not read from file '" + file + "'");
        }
    }

    //TODO: Make parameterized method that displays only one task
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
