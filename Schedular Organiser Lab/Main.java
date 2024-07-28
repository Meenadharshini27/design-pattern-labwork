import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        Observer observer = new Observer() {
            @Override
            public void notify(String message) {
                System.out.println(message);
            }
        };

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter start time: ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter end time: ");
                    String endTime = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    String priority = scanner.nextLine();

                    Task task = TaskFactory.createTask(description, startTime, endTime, priority);
                    scheduleManager.addTask(task);
                    observer.notify("Task added successfully.");
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    String removeDescription = scanner.nextLine();
                    Task removeTask = null;
                    for (Task task1 : scheduleManager.getTasks()) {
                        if (task1.getDescription().equals(removeDescription)) {
                            removeTask = task1;
                            break;
                        }
                    }
                    if (removeTask != null) {
                        scheduleManager.removeTask(removeTask);
                        observer.notify("Task removed successfully.");
                    } else {
                        observer.notify("Task not found.");
                    }
                    break;
                case 3:
                    scheduleManager.viewTasks();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    observer.notify("Invalid option.");
            }
        }
        scanner.close();
    }
}