import java.util.ArrayList;
public class Task{
    private String taskName;
    private final ArrayList<Double> scoreCollection = new ArrayList<>();

    public Task(String taskName, double urgencyScore){
        this.taskName = taskName;
        scoreCollection.add(urgencyScore);
    }

    public double calculatePriorityRanking(){
        double priorityRanking = 0.0;
        for (Double num : scoreCollection) {
            priorityRanking += num;
        }
        return priorityRanking;
    }

    public String getTaskName(){
        return taskName;
    }

}
