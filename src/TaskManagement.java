import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import task.Task;
import task.MergeSort;

// This driver class is responsible for running a terminal interface of the Task Management
// program
public class TaskManagement {

  public static void main(String []args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("*************** WELCOME TO PRIORITY TASK MANAGEMENT ***************");
    // Initialize all tasks list
    List<Task> allTasks = new ArrayList<>();
    while (true) {
      System.out.println("How many tasks would you like to add (any positive number)?");
      String input = scanner.nextLine();
      int numOfTasks = Integer.parseInt(input);
      System.out.println(input);
      for (int i = 1; i <= numOfTasks; i++) {
        System.out.println("Enter the name for task " + i);
        input = scanner.nextLine();
        String taskName = input;
        System.out.println("Enter the importance score for task " + i + " (from 1 to 10 inclusively)");
        input = scanner.nextLine();
        int importanceScore = Integer.parseInt(input);

      }

    }
  }
}