import java.util.Scanner;
import java.util.InputMismatchException;
public class AgeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Please enter your age: ");
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Age validation successful. You are " + age + " years old.");
        } catch (InvalidAgeException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number for age.");
        } finally {
            scanner.close();
        }
    }
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative.");
        } else if (age < 18) {
            throw new InvalidAgeException("You must be at least 18 years old. Current age: " + age);
        }
    }
}
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
