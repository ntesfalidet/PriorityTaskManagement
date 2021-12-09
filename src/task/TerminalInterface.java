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
                            "1. Recommend a task to complete now\n" +
                            "2. Print the task list you have not done\n" +
                            "3. Would you like to add more tasks? \n" +
                            "4. Print the task list you input in our system \n" +
                            "q. quit the program");
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
                    } else {
                        System.out.println("Seems there is no tasks now!");
                    }
                    homePage();
                    break;
                case "2":
                    String result = computeTaskLists.printAllTasks();
                    System.out.println(result);
                    homePage();
                    break;
                case "3":
                    addTask();
                    homePage();
                    break;
                case "4":
                    for (int i = 0; i < historyTaskList.size(); i++) {
                        System.out.println(historyTaskList.get(i));
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
        System.out.println("How many tasks would you like to add (any non-negative number)?");
        int taskNumber = Integer.valueOf(reader.readLine());
        int number = 1;
        while (number <= taskNumber) {
            System.out.println("Enter the task name for the " + number + " task");
            String taskName = reader.readLine();
            System.out.println("Enter the importance score for the " + number + " task (from 1 to 10)");
            String importanceStr = reader.readLine();
            int importance = Integer.valueOf(importanceStr);
            System.out.println("Enter the duration for the " + number + " task (in hours)");
            int duration = Integer.valueOf(reader.readLine());
            System.out.println("Does the " + " task have a deadline (yes or no)?");
            String hasDeadline = reader.readLine();
            String deadline = null;
            if (hasDeadline.toLowerCase().equals("yes")) {
                System.out.println("Enter the deadline for the " + number +
                        " task (in this format MM-dd-yyyy HH:mm, for example 12-22-2021 12:00)");
                deadline = reader.readLine();
            }
            Task task = new Task(taskName, importance, duration, deadline);
            list.add(task);
            historyTaskList.add(task);
            number++;
        }
        computeTaskLists = new ComputeTaskLists(list);
    }
}
