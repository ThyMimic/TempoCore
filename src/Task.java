import java.util.ArrayList;
public class Task{
    private String taskName;
    private int daysTillDue;
    private final ArrayList<Double> scoreCollection = new ArrayList<>();

    public Task(String taskName, double urgencyScore, int daysTillDue){
        this.daysTillDue = daysTillDue;
        this.taskName = taskName;
        scoreCollection.add(urgencyScore);
    }

    public double calculatePriorityRanking(){
        double priorityRanking = 0.0;
        for (Double num : scoreCollection){
            priorityRanking += num;
        }
        return priorityRanking;
    }

    public void changeTaskName(String newName){
        taskName = newName;
    }

    public String getTaskName(){
        return taskName;
    }
}
