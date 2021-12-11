package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalInterface {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Task> list = new ArrayList<>();
    List<Task> historyTaskList = new ArrayList<>();
    ComputeTaskLists computeTaskLists;

    public void homePage() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("What do you want to do now？\n" +
                            "1. Recommend a task to complete now (enter 1)\n" +
                            "2. Print the task list you have not done (enter 2)\n" +
                            "3. Would you like to add more tasks? (enter 3) \n" +
                            "4. Print the task list you input in our system, a history of added tasks (enter 4) \n" +
                            "q. quit the program (enter q)");
    }

    public void programStart() throws IOException, ParseException {
        System.out.println("Program start");
        System.out.println("---------------------------------------------------\n" +
                "Welcome to Task Management");
        addTask();
        String read = "";
        while (true) {
            switch (read) {
                case "1" :
                    Task task = computeTaskLists.recommendTask();
                    if (task != null) {
                        System.out.println("We recommend you do this task now:\n" +
                                task.toString());
                        System.out.println("The system will remove a recommend task from your "
                            + "tasks list. However, you can view the removed task from your "
                            + "history of tasks.");
                    } else {
                        System.out.println("You don't have any tasks at the moment!");
                    }
                    homePage();
                    break;
                case "2":
                    System.out.println("Your task list is divided into all tasks in sorted order "
                        + "by their importance scores and all urgent tasks (tasks with deadlines)\n"
                        + "in sorted order by their "
                        + "deadlines "
                        + "and latest start times."
                        + "\nIf there are urgent tasks with the same deadline, then the urgent "
                        + "tasks are in sorted by their importance scores and latest start times."
                        + "\nUrgent tasks have adjusted latest start times "
                        + "if the latest start times and deadlines of urgent tasks conflict with "
                        + "each other.");
                    System.out.println("************ ALL TASKS IN SORTED ORDER ************");
                    System.out.println(computeTaskLists.printAllTasks());
                    System.out.println("************ URGENT TASKS IN SORTED ORDER ************");
                    System.out.println(computeTaskLists.printUrgentTasks());
                    homePage();
                    break;
                case "3":
                    addTask();
                    homePage();
                    break;
                case "4":
                    System.out.println("************ HISTORY OF ALL ADDED TASKS ************");
                    if (historyTaskList.size() == 0) {
                     System.out.println("NO ADDED TASKS SO FAR");
                    }
                    else {
                        for (int i = 0; i < historyTaskList.size(); i++) {
                            System.out.println(historyTaskList.get(i));
                        }
                    }
                    homePage();
                    break;
                case "q":
                    System.out.println("bye!");
                    return;
                default:
                    homePage();
            }
            read = reader.readLine();
        }
    }

    public void addTask() throws ParseException, IOException {
        System.out.println("How many tasks would you like to add (any positive number)?");
        int taskNumber = Integer.valueOf(reader.readLine());
        int number = 1;
        while (number <= taskNumber) {
            System.out.println("Enter the task name for task " + number);
            String taskName = reader.readLine();
            System.out.println("Enter the importance score (from 1 to 10) for task " + number);
            String importanceStr = reader.readLine();
            int importance = Integer.valueOf(importanceStr);
            System.out.println("Enter the duration (in hours) for task " + number
                + " (eg. if duration is 3 hours input 3)");
            int duration = Integer.valueOf(reader.readLine());
            System.out.println("Does task " + number + " have a deadline (enter yes or no)?");
            String hasDeadline = reader.readLine();
            String deadline = null;
            if (hasDeadline.toLowerCase().equals("yes")) {
                System.out.println("Enter the deadline for task " + number +
                        " in this format MM-dd-yyyy HH:mm \n(eg. if the deadline date is "
                    + "April 25 2021 and deadline time is 05:50 PM then input 04-25-2021 17:50) "
                    + "\nNOTE: The hours are expressed in military time (12:00 AM to 11:00 AM "
                    + "is expressed as 00:00 to 11:00, and 12:00 PM to 11:00 PM is expressed as "
                    + "12:00 to 23:00)");
                deadline = reader.readLine();
            }
            Task task = new Task(taskName, importance, duration * 60 * 60 * 1000, deadline);
            list.add(task);
            historyTaskList.add(task);
            number++;
        }
        System.out.println("Performing Task Management sorting operations...");
        computeTaskLists = new ComputeTaskLists(list);
        // Sort all tasks in list by their importance scores from highest to lowest
        // (using merge sort)
        computeTaskLists.sortAllTasks();
        // Call initializeUrgentTasks() to initialize the urgent tasks (filters urgent tasks
        // out from list)
        computeTaskLists.initializeUrgentTasks();
        // Call sortUrgentTasks() method to sort all the urgent tasks by their deadlines
        // from earliest to latest
        computeTaskLists.sortUrgentTasks();
    }
}
