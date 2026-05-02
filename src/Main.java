public class Main{
    public static void main(String[] clackIndustries){


        /*
        Things of Note:

        1. Duplicate tasks cannot be added; file will act as if it was only initialized with one unique task
        2. Lists can be composed of other lists
            - Example: (Task organization for range of time in 2 months, each day inclusive)
                - 2 Month Primary List
                    - 4 Week Primary Lists each Month PL
                        - 7 Day Secondary Lists each Week PL
                            - 9 Tasks in each Day SL
        3. Primary lists can be made up of a near-infinite amount of secondary lists
        4. Secondary lists can only have up to 9 tasks contained
        5. Primary lists (PLs) are lists that can contain lists and tasks
        6. Secondary lists (SLs) are lists that cannot contain other lists (may only contain tasks)
         */

        var task1 = new Task("Homework", 2.5, 2);
        var task2 = new Task("Shopping", 2.5, 2);
        var task3 = new Task("Cleaning", 2.5, 2);

        taskList taskList = new taskList("Test List of Tasks");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);



        taskList.saveList();
        taskList.loadTask(3);
    }
}