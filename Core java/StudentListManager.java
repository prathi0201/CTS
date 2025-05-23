import java.util.ArrayList;
import java.util.Scanner;
public class StudentListManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        System.out.println("Student Name Manager");
        System.out.println("-------------------");
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a student name");
            System.out.println("2. View all student names");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String name = scanner.nextLine().trim();
                    if (!name.isEmpty()) {
                        studentNames.add(name);
                        System.out.println("Added: " + name);
                    } else {
                        System.out.println("Name cannot be empty.");
                    }
                    break;
                case 2:
                    displayStudentNames(studentNames);
                    break;
                case 3:
                    System.out.println("Exiting program. Final list of students:");
                    displayStudentNames(studentNames);
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
    private static void displayStudentNames(ArrayList<String> names) {
        if (names.isEmpty()) {
            System.out.println("No student names entered yet.");
        } else {
            System.out.println("\nList of Student Names:");
            System.out.println("----------------------");
            for (int i = 0; i < names.size(); i++) {
                System.out.println((i + 1) + ". " + names.get(i));
            }
            System.out.println("Total students: " + names.size());
        }
    }
}
