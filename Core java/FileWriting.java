import java.util.Scanner;
public class FileWritingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File Writer Program");
        System.out.println("-------------------");
        System.out.print("Enter text to write to file: ");
        String userInput = scanner.nextLine();
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(userInput);
            System.out.println("Successfully wrote to output.txt");
            System.out.println("You can find the file in: " + System.getProperty("user.dir"));
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
