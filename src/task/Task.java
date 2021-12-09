package task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// This class is responsible for holding the data attributes of a task
public class Task {
  private String taskName;
  private int importanceScore; // the importance score of task scaled from 1 to 10 (1 being the highest and 10 being the lowest)
  private long duration; // estimated time to complete a task in hours
  private Date deadline; // deadline date and time of a task
  private long latestStartTime; // the latest start time of a task

  public Task (String taskName, int importanceScore, int duration, String deadlineString)
      throws ParseException {
    this.taskName = taskName;
    this.importanceScore = importanceScore;
    this.duration = duration;
    if (deadlineString != null) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");
      this.deadline = simpleDateFormat.parse(deadlineString);
      this.latestStartTime = this.deadline.getTime() - duration;
    }
    else {
      this.deadline = null;
    }
  }

  // Gets the task name
  public String getTaskName() {
    return this.taskName;
  }

  // Gets the importance score of a task
  public int getImportanceScore() {
    return this.importanceScore;
  }

  // Gets the duration (estimated time of completion) of a task
  public long getDuration() {
    return this.duration;
  }

  // Gets the deadline of a task
  public Date getDeadline() {
    return this.deadline;
  }

  // Gets the latest start time of a task
  public long getLatestStartTime() {
    return this.latestStartTime;
  }

  // Sets the latest start time of a task by a given latestStartTime
  public void setLatestStartTime(long latestStartTime) {
    this.latestStartTime = latestStartTime;
  }

  // Prints out a task
  public String toString() {
    if (this.deadline != null) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");
      String deadlineString = simpleDateFormat.format(this.deadline);
      String latestStartTimeString = simpleDateFormat.format(new Date(this.latestStartTime));
      return "| Task name: " + this.taskName + " | Deadline: " + deadlineString + " | Duration: "
          + this.duration / (1000 * 60 * 60) + " hour(s) | Importance score: " + this.importanceScore
          + " | Latest start time: " + latestStartTimeString;
    }
    else {
      return "| Task name: " + this.taskName + " | Deadline: " + "No deadline" + " | Duration: "
          + this.duration / (1000 * 60 * 60) + " hour(s) | Importance score: " + this.importanceScore
          + " | Latest start time: " + "No latest start time";
    }
  }
}