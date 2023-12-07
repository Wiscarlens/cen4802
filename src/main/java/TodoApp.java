import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {

    private final ArrayList<String> tasks;
    private final Scanner scanner;

    public TodoApp() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Todo App Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    System.out.println("Exiting Todo App. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter the task: ");
        scanner.nextLine(); // consume the newline character
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private void viewTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void markTaskAsCompleted() {
        viewTasks();
        System.out.print("Enter the task number to mark as completed: ");
        int taskNumber = scanner.nextInt();

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            String completedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task marked as completed: " + completedTask);
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    public static void main(String[] args) {
        TodoApp todoApp = new TodoApp();
        todoApp.start();
    }
}
