import java.util.Scanner;
public class TypeCastingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type Casting Demonstration (with User Input)");
        System.out.println("------------------------------------------");
        System.out.print("Enter a decimal number (double value): ");
        double myDouble = scanner.nextDouble();
        System.out.println("Original double value: " + myDouble);
        int intFromDouble = (int) myDouble;
        System.out.println("double cast to int: " + intFromDouble);
        System.out.println("\n------------------------------------------");
        System.out.print("Enter a whole number (int value): ");
        int myInt = scanner.nextInt();
        System.out.println("Original int value: " + myInt);
        double doubleFromInt = (double) myInt;
        System.out.println("int cast to double: " + doubleFromInt);
        scanner.close();
    }
}
