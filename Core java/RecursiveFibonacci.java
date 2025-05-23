import java.util.Scanner;
public class RecursiveFibonacci {
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Recursive Fibonacci Calculator");
        System.out.println("------------------------------");
        System.out.print("Enter a positive integer (n) to find the nth Fibonacci number: ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            System.out.println("The " + n + "th Fibonacci number is: " + fibonacci(n));
        }
        scanner.close();
    }
}
