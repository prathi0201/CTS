import java.util.Scanner;
public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Array Sum and Average Calculator");
        System.out.println("--------------------------------");
        System.out.print("Enter the number of elements for the array: ");
        int size = scanner.nextInt();
        if (size <= 0) {
            System.out.println("Array size must be a positive number.");
            scanner.close();
            return;
        }
        int[] numbers = new int[size];
        int sum = 0;
        System.out.println("Enter " + size + " integer elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }
        System.out.println("\nSum of array elements: " + sum);
        double average = (double) sum / size;
        System.out.println("Average of array elements: " + average);
        scanner.close();
    }
}
