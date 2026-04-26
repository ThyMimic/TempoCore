public class Main{
    public static void main(String[] clackIndustries){
        var task = new Task("Homework", 2.5);
        var task2 = new Task("Shopping", 2.5);

        System.out.println(task.calculatePriorityRanking());
        System.out.println(task2.calculatePriorityRanking());

        taskList taskList = new taskList();

        taskList.addTask(task);
        taskList.addTask(task2);

        System.out.println();
        System.out.println();

        System.out.println(taskList.displayTasks());

        taskList.removeTask(task2);

        System.out.println(taskList.displayTasks());
    }
}