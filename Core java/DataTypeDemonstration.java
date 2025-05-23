import java.util.Scanner;
public class DataTypeDemonstration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Java Primitive Data Type Demonstration (User Input)");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter an integer value: ");
        int integerVar = scanner.nextInt(); /
        System.out.println("You entered for int: " + integerVar);
        scanner.nextLine();
        System.out.print("Enter a float value (e.g., 25.5): ");
        float floatVar = scanner.nextFloat();
        System.out.println("You entered for float: " + floatVar);
        scanner.nextLine();
        System.out.print("Enter a double value (e.g., 123.456): ");
        double doubleVar = scanner.nextDouble();
        System.out.println("You entered for double: " + doubleVar);
        scanner.nextLine();
        System.out.print("Enter a single character: ");
        char charVar = scanner.next().charAt(0);
        System.out.println("You entered for char: " + charVar);
        scanner.nextLine();
        System.out.print("Enter a boolean value (true/false): ");
        boolean booleanVar = scanner.nextBoolean();
        System.out.println("You entered for boolean: " + booleanVar);
        scanner.close();
    }
}
