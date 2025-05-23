import java.util.HashMap;
import java.util.Scanner;
public class StudentIDManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> studentMap = new HashMap<>();
        System.out.println("Student ID-Name Manager");
        System.out.println("-----------------------");
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a student ID and name");
            System.out.println("2. Lookup student by ID");
            System.out.println("3. View all students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1-4.");
                scanner.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    addStudent(scanner, studentMap);
                    break;
                case 2:
                    lookupStudent(scanner, studentMap);
                    break;
                case 3:
                    displayAllStudents(studentMap);
                    break;
                case 4:
                    System.out.println("Exiting program. Final student list:");
                    displayAllStudents(studentMap);
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }
    private static void addStudent(Scanner scanner, HashMap<Integer, String> map) {
        try {
            System.out.print("Enter student ID (number): ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (map.containsKey(id)) {
                System.out.println("ID already exists. Current name: " + map.get(id));
                System.out.print("Do you want to overwrite? (y/n): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (!response.equals("y")) {
                    return;
                }
            }
            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                map.put(id, name);
                System.out.println("Added: ID " + id + " -> " + name);
            } else {
                System.out.println("Name cannot be empty. Entry not added.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input for ID. Please enter a number.");
            scanner.nextLine();
        }
    }
    private static void lookupStudent(Scanner scanner, HashMap<Integer, String> map) {
        try {
            System.out.print("Enter student ID to lookup: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (map.containsKey(id)) {
                System.out.println("Student found: ID " + id + " -> " + map.get(id));
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Invalid input for ID. Please enter a number.");
            scanner.nextLine();
        }
    }
    private static void displayAllStudents(HashMap<Integer, String> map) {
        if (map.isEmpty()) {
            System.out.println("No students in the system yet.");
        } else {
            System.out.println("\nAll Students:");
            System.out.println("------------");
            for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println("ID: " + entry.getKey() + " | Name: " + entry.getValue());
            }
            System.out.println("Total students: " + map.size());
        }
    }
}
