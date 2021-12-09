package task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// This class is responsible for holding tasks data and performing
// ordering operations on tasks, and printing out the tasks
public class ComputeTaskLists {
  // All tasks (with and without deadlines)
  private List<Task> allTasks;
  // Tasks with deadlines
  private List<Task> urgentTasks = new ArrayList<>();
  // Tasks without deadlines
  private List<Task> importantTasks = new ArrayList<>();

  public ComputeTaskLists(List<Task> allTasks) {
    this.allTasks = allTasks;
  }

  // Helper function for filtering out all the important tasks (tasks without deadlines) from
  // all sorted tasks
  private void initializeImportantTasks() {
    this.importantTasks = this.allTasks.stream().filter((task) -> (task.getDeadline() == null)).collect(
        Collectors.toList());
  }

  // Helper function (that's called in our main methods in TaskManagement and TaskManagementTesting)
  // for filtering out all the urgent tasks (tasks with deadlines) from all sorted tasks
  public void initializeUrgentTasks() {
    this.urgentTasks = this.allTasks.stream().filter((task) -> (task.getDeadline() != null)).collect(
        Collectors.toList());
  }

  // Gets all the tasks
  public List<Task> getAllTasks () {
    return this.allTasks;
  }

  // Gets all the urgent tasks from all tasks (urgent tasks are tasks with deadlines)
  public List<Task> getUrgentTasks() {
    return this.urgentTasks;
  }

  // Gets all the important tasks from all tasks (important tasks are tasks without deadlines)
  public List<Task> getImportantTasks() {
    // Filter out all important tasks (tasks without deadlines) from all tasks
    this.initializeImportantTasks();
    return this.importantTasks;
  }

  // This method sorts all the tasks by their importance scores (using merge sort)
  public void sortAllTasks() {
    MergeSort mergeSort = new MergeSort(this.allTasks);
    mergeSort.sort(0, this.allTasks.size() - 1, true);
  }

  // Helper function for adjusting the latest start times of urgent tasks
  private void adjustLatestStartTimes(List<Task> urgentTasks, int index) {
    if (index == 0) {
      return;
    }
    if (urgentTasks.get(index - 1).getDeadline().getTime() > urgentTasks.get(index).getLatestStartTime()) {
      Task previousTask = urgentTasks.get(index - 1);

      previousTask.setLatestStartTime(previousTask.getLatestStartTime()
          - (previousTask.getDeadline().getTime() - urgentTasks.get(index).getLatestStartTime()));
    }
    adjustLatestStartTimes(urgentTasks, index - 1);
  }

  // This method sorts all the urgent tasks by their deadlines (from earliest to latest deadline)
  // If there are urgent tasks that conflict with each other, with respect to an urgent task's
  // deadline and latest start time, then we call a helper function to adjust the latest start times
  // for conflicting urgent tasks appropriately.
  public void sortUrgentTasks() {
    // Sorts the urgent tasks by their deadlines and if some urgent tasks have the same deadlines,
    // then we sort those urgent tasks by their importance score
    // (for debugging purposes)
//    Collections.sort(this.urgentTasks, (a, b) -> (a.getDeadline().compareTo(b.getDeadline()) == 0
//        ? b.getImportanceScore() - a.getImportanceScore() : a.getDeadline().compareTo(b.getDeadline())));

    // Sorts the urgent tasks by only their deadlines (using merge sort)
    MergeSort mergeSort = new MergeSort(this.urgentTasks);
    mergeSort.sort(0, this.urgentTasks.size() - 1, false);

    // Helper function is called here for adjusting the latest start times for any conflicting
    // urgent tasks
    this.adjustLatestStartTimes(this.urgentTasks, this.urgentTasks.size() - 1);
  }

  // This method is responsible for returning the recommended task, out of all the tasks, to
  // complete now
  public Task recommendTask() {
    // We compare the first element in the allTasks list (sorted) and
    // the first element in the urgentTasks list.
    // If the sum of the current time and the duration of the first element in the allTasks list
    // is greater than or equal to the latest start time of the first element in the urgentTasks
    // list, then the method recommends the user to complete the first element in the allTasks list
    // now.

    // Get current date (the date now)
    Date currentDate = new Date();
    // Get current time of current date
    long currentTime = currentDate.getTime();

    // Print out the current time in a specific date and time format (for debugging)
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");
    System.out.println("Current date and time: " + simpleDateFormat.format(currentDate));


    if (currentTime + this.allTasks.get(0).getDuration() < this.urgentTasks.get(0).getLatestStartTime()) {
      return this.allTasks.get(0);
    }

    // Otherwise, the method recommends the user to complete the first element in the urgentTasks
    // list now.
    else {
      return urgentTasks.get(0);
    }
  }

  // Prints all tasks
  public String printAllTasks() {
    StringBuilder printAllTasksResult = new StringBuilder();
    for (Task task: getAllTasks()) {
      printAllTasksResult.append(task.toString());
      printAllTasksResult.append("\n");
    }
    return printAllTasksResult.toString();
  }

  // Prints urgent tasks
  public String printUrgentTasks() {
    StringBuilder printUrgentTasksResult = new StringBuilder();
    for (Task urgentTask: getUrgentTasks()) {
      printUrgentTasksResult.append(urgentTask.toString());
      printUrgentTasksResult.append("\n");
    }
    return printUrgentTasksResult.toString();
  }

  // Prints important tasks
  public String printImportantTasks() {
    StringBuilder printImportantTasksResult = new StringBuilder();
    for (Task importantTask: getImportantTasks()) {
      printImportantTasksResult.append(importantTask.toString());
      printImportantTasksResult.append("\n");
    }
    return printImportantTasksResult.toString();
  }
}
