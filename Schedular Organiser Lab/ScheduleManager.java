import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        // Validate no conflicts
        if (!hasConflicts(task)) {
            tasks.add(task);
        } else {
            System.out.println("Error: Task conflicts with existing task.");
        }
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void viewTasks() {
        tasks.sort((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }

    private boolean hasConflicts(Task task) {
        for (Task existingTask : tasks) {
            LocalTime taskStartTime = LocalTime.parse(task.getStartTime());
            LocalTime taskEndTime = LocalTime.parse(task.getEndTime());
            LocalTime existingTaskStartTime = LocalTime.parse(existingTask.getStartTime());
            LocalTime existingTaskEndTime = LocalTime.parse(existingTask.getEndTime());

            if (taskStartTime.isBefore(existingTaskEndTime) && taskEndTime.isAfter(existingTaskStartTime)) {
                return true;
            }
        }
        return false;
    }


    public List<Task> getTasks() {
        return tasks;
    }
}