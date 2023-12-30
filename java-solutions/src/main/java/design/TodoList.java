package design;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * @author FLIGHT
 * <p>
 * 2590. Design to do list
 * Medium
 * 30
 * 13
 * Design to do List Where users can add tasks, mark them as complete,
 * or get a list of pending tasks. Users can also add tags to tasks and can filter the tasks by certain tags.
 * <p>
 * Implement the TodoList class:
 * <p>
 * TodoList() Initializes the object.
 * int addTask(int userId, String taskDescription, int dueDate, List<String> tags)
 * Adds a task for the user with the ID userId with a due date equal to dueDate and a list of tags attached to the task.
 * The return value is the ID of the task. This ID starts at 1 and is sequentially increasing.
 * That is, the first task's id should be 1, the second task's id should be 2, and so on.
 * <p>
 * List<String> getAllTasks(int userId) Returns a list of all the tasks not marked as complete for the user with ID userId,
 * ordered by the due date. You should return an empty list if the user has no uncompleted tasks.
 * <p>
 * List<String> getTasksForTag(int userId, String tag) Returns a list of all the tasks that are not marked as complete
 * for the user with the ID userId and have tag as one of their tags, ordered by their due date.
 * Return an empty list if no such task exists.
 * <p>
 * void completeTask(int userId, int taskId) Marks the task with the ID taskId as completed only
 * if the task exists and the user with the ID userId has this task, and it is uncompleted.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["TodoList", "addTask", "addTask", "getAllTasks", "getAllTasks", "addTask", "getTasksForTag", "completeTask", "completeTask", "getTasksForTag", "getAllTasks"]
 * [[], [1, "Task1", 50, []], [1, "Task2", 100, ["P1"]], [1], [5], [1, "Task3", 30, ["P1"]], [1, "P1"], [5, 1], [1, 2], [1, "P1"], [1]]
 * Output
 * [null, 1, 2, ["Task1", "Task2"], [], 3, ["Task3", "Task2"], null, null, ["Task3"], ["Task3", "Task1"]]
 * <p>
 * Explanation
 * TodoList todoList = new TodoList();
 * todoList.addTask(1, "Task1", 50, []); // return 1. This adds a new task for the user with id 1.
 * todoList.addTask(1, "Task2", 100, ["P1"]); // return 2. This adds another task for the user with id 1.
 * todoList.getAllTasks(1); // return ["Task1", "Task2"]. User 1 has two uncompleted tasks so far.
 * todoList.getAllTasks(5); // return []. User 5 does not have any tasks so far.
 * todoList.addTask(1, "Task3", 30, ["P1"]); // return 3. This adds another task for the user with id 1.
 * todoList.getTasksForTag(1, "P1"); // return ["Task3", "Task2"]. This returns the uncompleted tasks that have the tag "P1" for the user with id 1.
 * todoList.completeTask(5, 1); // This does nothing, since task 1 does not belong to user 5.
 * todoList.completeTask(1, 2); // This marks task 2 as completed.
 * todoList.getTasksForTag(1, "P1"); // return ["Task3"]. This returns the uncompleted tasks that have the tag "P1" for the user with id 1.
 * // Notice that we did not include "Task2" because it is completed now.
 * todoList.getAllTasks(1); // return ["Task3", "Task1"]. User 1 now has 2 uncompleted tasks.
 */
public class TodoList {

  private final Map<Integer, Set<Task>> tasks;

  private final Map<Integer, Task> indexTable;

  private final AtomicInteger counter;

  public TodoList() {
    tasks = new HashMap<>();
    indexTable = new HashMap<>();
    counter = new AtomicInteger();
  }

  public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
    Task task = new Task(taskDescription, dueDate, new HashSet<>(tags));

    int index = counter.incrementAndGet();
    tasks.computeIfAbsent(userId, p -> new HashSet<>()).add(task);
    indexTable.put(index, task);

    return index;
  }

  public List<String> getAllTasks(int userId) {
    return getTasks(userId, task -> true);
  }

  public List<String> getTasksForTag(int userId, String tag) {
    return getTasks(userId, task -> task.tags().contains(tag));
  }

  public List<String> getTasks(int userId, Predicate<Task> predicate) {
    return tasks.getOrDefault(userId, Collections.emptySet()).stream()
      .sorted(Comparator.comparing(Task::date))
      .filter(predicate)
      .map(Task::description)
      .toList();
  }

  public void completeTask(int userId, int taskId) {
    Task task = indexTable.get(taskId);
    tasks.getOrDefault(userId, Collections.emptySet()).remove(task);
  }

  public record Task(String description, int date, Set<String> tags) {
  }
}
