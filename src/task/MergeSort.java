package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// MergeSort class for sorting a list of tasks
// When sorting a list of tasks by their importance score (from highest to lowest)
public class MergeSort {
  private List<Task> tasksList = new ArrayList<>();

  public MergeSort(List<Task> tasksList) {
    this.tasksList = tasksList;
  }

  // merge the two sublists (left sublist and right sublist) of tasksList
  // left sublist is tasksList[leftIdx...midIdx] and right sublist is tasksList[midIdx + 1...rightIdx]
  private void merge(int leftIdx, int midIdx, int rightIdx, boolean isAllTasks) {
    // Sizes of two sublists
    int leftSublistSize = midIdx - leftIdx + 1;
    int rightSublistSize = rightIdx - midIdx;

    // Get elements for the left and right sublists of tasksList
    List<Task> leftSublist = Arrays.asList(new Task[leftSublistSize]);
    List<Task> rightSublist = Arrays.asList(new Task[rightSublistSize]);

    for (int i = 0; i < leftSublistSize; i++) {
      leftSublist.set(i, this.tasksList.get(leftIdx + i));
    }
    for (int j = 0; j < rightSublistSize; j++) {
      rightSublist.set(j, this.tasksList.get(midIdx + 1 + j));
    }

    // We merge our two sublists, left and right sublists
    // Indices for the left and right sublists
    int i = 0;
    int j = 0;

    // Index of tasksList when merging the left and right sublists
    int tempIdx = leftIdx;
    while (i < leftSublistSize && j < rightSublistSize) {
      // If isAllTasks is true then we sort the tasks in our tasksList (which contains all tasks)
      // based on their importance score (from highest to lowest)
      if (isAllTasks) {
        if (leftSublist.get(i).getImportanceScore() >= rightSublist.get(j).getImportanceScore()) {
          this.tasksList.set(tempIdx, leftSublist.get(i));
          i++;
        }
        else {
          this.tasksList.set(tempIdx, rightSublist.get(j));
          j++;
        }
      }

      // Otherwise we sort the tasks in our tasksList (which contains all urgent tasks)
      // based on their deadlines (from earliest to latest)
      else {
        if (leftSublist.get(i).getDeadline().compareTo(rightSublist.get(j).getDeadline()) <= 0) {
          this.tasksList.set(tempIdx, leftSublist.get(i));
          i++;
        }
        else {
          this.tasksList.set(tempIdx, rightSublist.get(j));
          j++;
        }
      }
      tempIdx++;
    }

    while (i < leftSublistSize) {
      this.tasksList.set(tempIdx, leftSublist.get(i));
      i++;
      tempIdx++;
    }

    while (j < rightSublistSize) {
      this.tasksList.set(tempIdx, rightSublist.get(j));
      j++;
      tempIdx++;
    }
  }

  // sort method performs merge sort
  // if isAllTasks boolean is true then the tasks list we are dealing with is allTasks
  // we then sort our list of all tasks by their importance scores (from highest to lowest)
  // if isAllTasks boolean is false then the tasks list we are dealing with is urgentTasks
  // we then sort our list of all urgent tasks by their deadlines (from earliest to latest)
  public void sort(int leftIdx, int rightIdx, boolean isAllTasks) {
    if (leftIdx < rightIdx) {
      // Compute for middle index when performing merge sort
      int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

      // Sort left half and right half of tasksList
      sort(leftIdx, midIdx, isAllTasks);
      sort(midIdx + 1, rightIdx, isAllTasks);

      // Merge sorted halves
      this.merge(leftIdx, midIdx, rightIdx, isAllTasks);
    }
  }
}
