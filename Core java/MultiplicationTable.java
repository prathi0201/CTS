import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Multiplication Table Generator");
        System.out.println("------------------------------");
        System.out.print("Enter a number to see its multiplication table: ");
        int number = scanner.nextInt(); 
        System.out.println("\nMultiplication Table for " + number + " (up to 10):");
        for (int i = 1; i <= 10; i++) {
            // Multiply the input number by the loop counter and display the result
            System.out.println(number + " x " + i + " = " + (number * i));
        }
        scanner.close();
    }
}
