import java.util.Scanner;
public class MethodOverloading {
    public int add(int a, int b) {
        System.out.println("\nAdding two integers: " + a + " + " + b);
        return a + b;
    }
    public double add(double a, double b) {
        System.out.println("\nAdding two doubles: " + a + " + " + b);
        return a + b;
    }
    public int add(int a, int b, int c) {
        System.out.println("\nAdding three integers: " + a + " + " + b + " + " + c);
        return a + b + c;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MethodOverloading calculator = new MethodOverloading();
        System.out.println("Method Overloading Demonstration (with User Input)");
        System.out.println("--------------------------------------------------");
        System.out.println("\n--- Adding two integers ---");
        System.out.print("Enter first integer: ");
        int int1 = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int int2 = scanner.nextInt();
        int sumInts = calculator.add(int1, int2);
        System.out.println("Result: " + sumInts);
        System.out.println("\n--- Adding two doubles ---");
        System.out.print("Enter first double: ");
        double double1 = scanner.nextDouble();
        System.out.print("Enter second double: ");
        double double2 = scanner.nextDouble();
        double sumDoubles = calculator.add(double1, double2);
        System.out.println("Result: " + sumDoubles);
        System.out.println("\n--- Adding three integers ---");
        System.out.print("Enter first integer: ");
        int int3 = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int int4 = scanner.nextInt();
        System.out.print("Enter third integer: ");
        int int5 = scanner.nextInt();
        int sumThreeInts = calculator.add(int3, int4, int5);
        System.out.println("Result: " + sumThreeInts);
        scanner.close();
    }
}
