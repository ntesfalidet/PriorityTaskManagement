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
//    allTasks1.add(new Task("test for web dev", 3, 9 * 60 * 60 * 1000,
//        "11-21-2021 22:00"));
//    allTasks1.add(new Task("5610 final project", 9, 7 * 60 * 60 * 1000,
//        "11-21-2021 23:00"));
//    allTasks1.add(new Task("5800 quiz", 7, 3 * 60 * 60 * 1000,
//        "11-30-2021 22:00"));
//    allTasks1.add(new Task("5800 assignment", 6, 1 * 60 * 60 * 1000,
//        "11-30-2021 22:00"));
//    allTasks1.add(new Task("prepare for the interview", 10, 5 * 60 * 60 * 1000,
//        null));
//    allTasks1.add(new Task("learn java", 8, 3 * 60 * 60 * 1000,
//        null));

    // Test Case 2 (for testing tasks with the same deadline and same duration)
    allTasks1.add(new Task("t1", 5, 3 * 60 * 60 * 1000,
        "12-12-2021 12:00"));
    allTasks1.add(new Task("t2", 8, 3 * 60 * 60 * 1000,
        "12-12-2021 12:00"));
    allTasks1.add(new Task("t3", 6, 3 * 60 * 60 * 1000,
        "12-12-2021 12:00"));
    allTasks1.add(new Task("t4", 1, 3 * 60 * 60 * 1000,
        "12-12-2021 12:00"));
    allTasks1.add(new Task("t5", 9, 3 * 60 * 60 * 1000,
        "12-12-2021 12:00"));
    allTasks1.add(new Task("t6", 5, 3 * 60 * 60 * 1000,
        null));

//    // Test Case 3 (for testing tasks with the same deadline and same duration)
//    allTasks1.add(new Task("t1", 5, 3 * 60 * 60 * 1000,
//        "12-12-2021 12:00"));
//    allTasks1.add(new Task("t2", 8, 3 * 60 * 60 * 1000,
//        "12-12-2021 12:00"));
//    allTasks1.add(new Task("t3", 6, 3 * 60 * 60 * 1000,
//        "12-12-2021 12:00"));
//    allTasks1.add(new Task("t4", 1, 3 * 60 * 60 * 1000,
//        "12-12-2021 11:00"));
//    allTasks1.add(new Task("t5", 9, 3 * 60 * 60 * 1000,
//        "12-12-2021 12:00"));
//    allTasks1.add(new Task("t6", 5, 3 * 60 * 60 * 1000,
//        null));

    // Test Case 4 (for testing the recommended task to complete now functionality)
//    allTasks1.add(new Task("t1", 8, 3 * 60 * 60 * 1000,
//        "12-09-2021 07:50"));  // 7:50 AM
//    allTasks1.add(new Task("t2", 9, 3 * 60 * 60 * 1000,
//        null));


    /// Add more test cases here ///

    /////////////////////////////////////////////////////////////////////////////////////////////

    // Call ComputeTaskLists class
    ComputeTaskLists computeTaskLists = new ComputeTaskLists(allTasks1);

    // Sort all tasks in allTasks1 list by their importance score from highest to lowest
    // (using merge sort)
    // Print all the tasks in sorted order (by importance)
    computeTaskLists.sortAllTasks();
    System.out.println("************ ALL TASKS IN SORTED ORDER BY IMPORTANCE ************");
    System.out.println(computeTaskLists.printAllTasks());

    // Get all the urgent tasks from all tasks (allTasks1 list)
    // Print all the urgent tasks
    System.out.println("************ URGENT TASKS ************");
    System.out.println(computeTaskLists.printUrgentTasks());

    // Get all the important tasks from all tasks (allTasks1 list)
    // Print all the important tasks
    System.out.println("************ IMPORTANT TASKS ************");
    System.out.println(computeTaskLists.printImportantTasks());

    // Get all the urgent tasks in sorted order (sort urgent tasks by their deadlines)
    // Print all the urgent tasks in sorted order (by their deadlines)
    System.out.println("************ URGENT TASKS IN SORTED ORDER ************");
    System.out.println(computeTaskLists.printSortedUrgentTasks());

    // Print the recommended task for the user to complete now
    System.out.println("************ RECOMMENDED TASK TO COMPLETE NOW ************");
    System.out.println(computeTaskLists.recommendTask().toString());
  }
}
