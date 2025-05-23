import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class FileReadingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File Reader Program");
        System.out.println("------------------");
        System.out.print("Enter the filename to read (default: output.txt): ");
        String filename = scanner.nextLine().trim();
        if (filename.isEmpty()) {
            filename = "output.txt";
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("\nFile contents of " + filename + ":");
            System.out.println("--------------------------------");
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            if (lineNumber == 1) {
                System.out.println("(File is empty)");
            }
        } catch (IOException e) {
            System.out.println("\nError reading the file: " + e.getMessage());
            System.out.println("Please check: ");
            System.out.println("1. The file exists");
            System.out.println("2. You have proper permissions");
            System.out.println("3. The filename is correct");
        } finally {
            scanner.close();
        }
    }
}
