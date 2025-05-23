import java.util.*;
import java.util.stream.Collectors;
public class StreamEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.print("How many numbers do you want to enter? ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            numbers.add(scanner.nextInt());
        }
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("\nOriginal List: " + numbers);
        System.out.println("Filtered Even Numbers: " + evenNumbers);
    }
}
