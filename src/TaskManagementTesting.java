import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import task.Task;
import task.ComputeTaskLists;

public class TaskManagementTesting {
  public static void main(String []args) throws ParseException {
    List<Task> allTasks1 = new ArrayList<>();

    ///////////////////////////////////// ALL THE TEST CASES /////////////////////////////////////

    // Test Case 1
//    allTasks1.add(new Task("t1", 3, 9 * 60 * 60 * 1000,
//        "11-21-2021 22:00"));
//    allTasks1.add(new Task("t2", 9, 7 * 60 * 60 * 1000,
//        "11-21-2021 23:00"));
//    allTasks1.add(new Task("t3", 7, 3 * 60 * 60 * 1000,
//        "11-30-2021 22:00"));
//    allTasks1.add(new Task("t4", 6, 1 * 60 * 60 * 1000,
//        "11-30-2021 22:00"));
//    allTasks1.add(new Task("t5", 10, 5 * 60 * 60 * 1000,
//        null));
//    allTasks1.add(new Task("t6", 8, 3 * 60 * 60 * 1000,
//        null));

    // Test Case 2 (for testing tasks with the same deadline and same duration)
//    allTasks1.add(new Task("t1", 5, 3 * 60 * 60 * 1000,
//        "12-12-2021 12:00"));
//    allTasks1.add(new Task("t2", 8, 3 * 60 * 60 * 1000,
//        "12-12-2021 12:00"));
//    allTasks1.add(new Task("t3", 6, 3 * 60 * 60 * 1000,
//        "12-12-2021 12:00"));
//    allTasks1.add(new Task("t4", 1, 3 * 60 * 60 * 1000,
//        "12-12-2021 12:00"));
//    allTasks1.add(new Task("t5", 9, 3 * 60 * 60 * 1000,
//        "12-12-2021 12:00"));
//    allTasks1.add(new Task("t6", 5, 3 * 60 * 60 * 1000,
//        null));

//    // Test Case 3 (for testing tasks with the same deadline and same duration)
    allTasks1.add(new Task("t1", 5, 3 * 60 * 60 * 1000,
        "12-12-2021 12:00"));
    allTasks1.add(new Task("t2", 8, 3 * 60 * 60 * 1000,
        "12-12-2021 12:00"));
    allTasks1.add(new Task("t3", 6, 3 * 60 * 60 * 1000,
        "12-12-2021 12:00"));
    allTasks1.add(new Task("t4", 1, 3 * 60 * 60 * 1000,
        "12-12-2021 11:00"));
    allTasks1.add(new Task("t5", 9, 3 * 60 * 60 * 1000,
        "12-12-2021 12:00"));
    allTasks1.add(new Task("t6", 5, 3 * 60 * 60 * 1000,
        null));

    // Test Case 4 (for testing the recommended task to complete now functionality)
//    allTasks1.add(new Task("t1", 8, 3 * 60 * 60 * 1000,
//        "12-09-2021 20:50"));  // 8:50 PM
//    allTasks1.add(new Task("t2", 9, 3 * 60 * 60 * 1000,
//        null));


    /// Add more test cases here ///

    /////////////////////////////////////////////////////////////////////////////////////////////

    // Call ComputeTaskLists class
    ComputeTaskLists computeTaskLists = new ComputeTaskLists(allTasks1);

    // Sort all tasks in list by their importance scores from highest to lowest
    // (using merge sort)
    computeTaskLists.sortAllTasks();
    // Call initializeUrgentTasks() to initialize the urgent tasks (filters urgent tasks
    // out from list)
    computeTaskLists.initializeUrgentTasks();
    // Call sortUrgentTasks() method to sort all the urgent tasks by their deadlines
    // from earliest to latest
    computeTaskLists.sortUrgentTasks();
    System.out.println("Your task list is divided into all tasks in sorted order "
        + "by their importance scores and all urgent tasks (tasks with deadlines)\n"
        + "in sorted order by their "
        + "deadlines "
        + "and importance scores.\nUrgent tasks have adjusted latest start times "
        + "if the latest start times and deadlines of urgent tasks conflict with "
        + "each other.");
    System.out.println("************ ALL TASKS IN SORTED ORDER ************");
    System.out.println(computeTaskLists.printAllTasks());
    System.out.println("************ URGENT TASKS IN SORTED ORDER ************");
    System.out.println(computeTaskLists.printUrgentTasks());

    // For recommending a task to do now
    Task task = computeTaskLists.recommendTask();
    if (task != null) {
      System.out.println("We recommend you do this task now:\n" +
          task.toString());
      System.out.println("The system will remove a recommend task from your "
          + "tasks list. However, you can view the removed task from your "
          + "history of tasks.");
    }

    System.out.println("-------------------------------------------------------");
    System.out.println("Your task list is divided into all tasks in sorted order "
        + "by their importance scores and all urgent tasks (tasks with deadlines)\n"
        + "in sorted order by their "
        + "deadlines "
        + "and importance scores.\nUrgent tasks have adjusted latest start times "
        + "if the latest start times and deadlines of urgent tasks conflict with "
        + "each other.");
    System.out.println("************ ALL TASKS IN SORTED ORDER ************");
    System.out.println(computeTaskLists.printAllTasks());
    System.out.println("************ URGENT TASKS IN SORTED ORDER ************");
    System.out.println(computeTaskLists.printUrgentTasks());


    // FOR DEBUGGING PURPOSES
//    // Sort all tasks in allTasks1 list by their importance scores from highest to lowest
//    // (using merge sort)
//    computeTaskLists.sortAllTasks();
//    // Get all the tasks in sorted order (by their importance scores)
//    // Print all the tasks
//    System.out.println("************ ALL TASKS IN SORTED ORDER BY IMPORTANCE ************");
//    System.out.println(computeTaskLists.printAllTasks());
//
//    // Call initializeUrgentTasks() to initialize the urgent tasks (filters urgent tasks out from
//    // allTasks1 list)
//    computeTaskLists.initializeUrgentTasks();
//
//    // Get all the urgent tasks from all tasks (allTasks1 list)
//    // Print all the urgent tasks
//    System.out.println("************ URGENT TASKS ************");
//    System.out.println(computeTaskLists.printUrgentTasks());
//
//    // Get all the important tasks from all tasks (allTasks1 list)
//    // Print all the important tasks
//    System.out.println("************ IMPORTANT TASKS ************");
//    System.out.println(computeTaskLists.printImportantTasks());
//
//    // Call sortUrgentTasks() method to sort all the urgent tasks by their deadlines from earliest
//    // to latest
//    computeTaskLists.sortUrgentTasks();
//
//    // Get all the urgent tasks in sorted order (by their deadlines)
//    // Print all the sorted urgent tasks
//    System.out.println("************ URGENT TASKS IN SORTED ORDER ************");
//    System.out.println(computeTaskLists.printUrgentTasks());
//
//    // Print the recommended task for the user to complete now
//    System.out.println("************ RECOMMENDED TASK TO COMPLETE NOW ************");
//    System.out.println(computeTaskLists.recommendTask().toString());
  }
}

