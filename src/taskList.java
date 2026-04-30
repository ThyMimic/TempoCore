import java.io.*;
import java.util.LinkedHashMap;


public class taskList{
    private final LinkedHashMap<String, Task> taskList;
    private final File file;

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

    //Load the entire list of tasks as is
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

    //Load a single task based on a task name in tasklist
    //First index is always at 8; second index depends on the length of the task name and isn't inclusive
    public void loadTask(String taskName){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                if (line.isEmpty()){
                    continue;
                }
                int secondIndex = line.indexOf("/") - 1;
                if (line.substring(8, secondIndex).equals(taskName)){
                    System.out.println(line);
                }
            }
        }
        catch (IOException error){
            System.out.println("Catastrophic Error: Could not read from file '" + file + "'");
        }
    }

    public void loadTask(int taskIndex){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                if (line.isEmpty()){
                    continue;
                }
                String tempLine = line.substring(5, 6);    //Condenses the read line into the integer index only
                int readIndex = Integer.parseInt(tempLine); //Parses the condensed line
                if (taskIndex == readIndex){
                    System.out.println(line);   //Reads from the original line
                }
            }
        }
        catch (IOException error){
            System.out.println("Catastrophic Error: Could not read from file '" + file + "'");
        }
    }

    public void addTask(Task task){
        taskList.put(task.getTaskName(), task);
    }

    public void removeTask(Task task){
        taskList.remove(task.getTaskName());
    }
}
