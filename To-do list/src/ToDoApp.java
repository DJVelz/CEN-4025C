import java.util.*;

public class ToDoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();
        boolean running = true;

        System.out.println("Welcome to your To-Do List.");

        while (running) {
            System.out.println("\nHere are your options: ");
            System.out.println("1. View to-do list");
            System.out.println("2. Add a new item to the list");
            System.out.println("3. Delete an item from the list");
            System.out.println("4. Exit");

            System.out.println("\nWhat would you like to do? ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    List<String> items = toDoList.getItems();
                    if (toDoList.isEmpty()) {
                        System.out.println("Your to-do list is empty.");
                    } else {
                        System.out.println("Your to-do list:");
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println((i + 1) + ". " + items.get(i));
                        }
                    }
                    break;
                case "2":
                    System.out.print("Enter an item to add: ");
                    String newItem = sc.nextLine();
                    toDoList.add(newItem);
                    break;
                case "3":
                    System.out.print("Enter the number of the item to delete: ");
                    try {
                        int index = Integer.parseInt(sc.nextLine()) - 1;
                        toDoList.remove(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    break;
                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
