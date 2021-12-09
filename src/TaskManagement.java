import java.io.IOException;
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
import task.TerminalInterface;

// This driver class is responsible for running a terminal interface of the Task Management
// program
public class TaskManagement {

  public static void main(String []args) throws ParseException, IOException {

    TerminalInterface terminalInterface = new TerminalInterface();
    terminalInterface.programStart();
  }
}