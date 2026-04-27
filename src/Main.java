public class Main{
    public static void main(String[] clackIndustries){


        var task1 = new Task("Homework", 2.5);
        var task2 = new Task("Shopping", 2.5);
        var task3 = new Task("Cleaning", 2.5);

        taskList taskList = new taskList("Test List of Tasks");

        taskList.addTask(task1);
        taskList.addTask(task2);


        taskList.saveList();
        taskList.loadList();
    }
}