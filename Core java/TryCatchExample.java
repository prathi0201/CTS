import java.util.InputMismatchException;
import java.util.Scanner;
public class DivisionWithExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the first integer (numerator): ");
            int numerator = scanner.nextInt();
            System.out.print("Enter the second integer (denominator): ");
            int denominator = scanner.nextInt();
            double result = divideNumbers(numerator, denominator);
            System.out.println("Result of division: " + numerator + " / " + denominator + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers only.");
        } finally {
            scanner.close();
            System.out.println("Operation completed.");
        }
    }
    public static double divideNumbers(int numerator, int denominator) {
        return (double) numerator / denominator;
    }
}
