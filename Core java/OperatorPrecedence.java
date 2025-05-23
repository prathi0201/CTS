import java.util.Scanner;
public class OperatorPrecedence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Operator Precedence Demonstration (with User Input)");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter a value for 'a' (e.g., 10): ");
        int a = scanner.nextInt();
        System.out.print("Enter a value for 'b' (e.g., 5): ");
        int b = scanner.nextInt();
        System.out.print("Enter a value for 'c' (e.g., 2): ");
        int c = scanner.nextInt();
        int result1 = a + b * c;
        System.out.println("\nExpression: " + a + " + " + b + " * " + c);
        System.out.println("Result (multiplication first): " + result1);
        System.out.println("\n-------------------------------------------------");
        System.out.print("Enter a value for 'x' (e.g., 20): ");
        double x = scanner.nextDouble();
        System.out.print("Enter a value for 'y' (e.g., 4): ");
        double y = scanner.nextDouble();
        System.out.print("Enter a value for 'z' (e.g., 3): ");
        double z = scanner.nextDouble();
        double result2 = x / y * z;
        System.out.println("\nExpression: " + x + " / " + y + " * " + z);
        System.out.println("Result (left-to-right for same precedence): " + result2);
        System.out.println("\n-------------------------------------------------");
        System.out.print("Enter a value for 'p' (e.g., 10): ");
        int p = scanner.nextInt();
        System.out.print("Enter a value for 'q' (e.g., 5): ");
        int q = scanner.nextInt();
        System.out.print("Enter a value for 'r' (e.g., 2): ");
        int r = scanner.nextInt();
        int result3 = (p + q) * r;
        System.out.println("\nExpression: (" + p + " + " + q + ") * " + r);
        System.out.println("Result (parentheses first): " + result3);
        scanner.close();
    }
}
