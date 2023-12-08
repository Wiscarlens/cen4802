import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TodoApp {

    private List<String> todoList;

    public TodoApp() {
        todoList = new ArrayList<>();
    }

    public void addTodo(String todo) {
        todoList.add(todo);
    }

    public void removeTodo(String todo) {
        todoList.remove(todo);
    }

    public List<String> getTodoList() {
        return todoList;
    }

    public static void main(String[] args) {
        // Set the Datadog API key as a system property
        System.setProperty("datadog.api.key", "4bc6267b78492c5f83c34c18df2b3348");

        // Enable DataDog agent instrumentation
        System.setProperty("datadog.tracer.agent.enabled", "true");

        // Set the service name for your application
        System.setProperty("datadog.service.name", "your-application-name");


        TodoApp todoApp = new TodoApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add TODO");
            System.out.println("2. Remove TODO");
            System.out.println("3. Show TODO List");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter TODO: ");
                    String todo = scanner.nextLine();
                    todoApp.addTodo(todo);
                    break;
                case 2:
                    System.out.print("Enter TODO to remove: ");
                    String todoToRemove = scanner.nextLine();
                    todoApp.removeTodo(todoToRemove);
                    break;
                case 3:
                    System.out.println("TODO List:");
                    List<String> todoList = todoApp.getTodoList();
                    for (String item : todoList) {
                        System.out.println(item);
                    }
                    break;
                case 4:
                    System.out.println("Exiting TODO App. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

            shutdown();
        }
    }

    private static void shutdown() {
    }
}
