.import java.util.*;
public class LambdaSortExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        System.out.print("How many strings do you want to enter? ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter string " + i + ": ");
            words.add(scanner.nextLine());
        }
        System.out.println("\nOriginal list:");
        words.forEach(System.out::println);
        Collections.sort(words, (s1, s2) -> s1.compareTo(s2));
        System.out.println("\nSorted list (Alphabetical):");
        words.forEach(System.out::println);
        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("\nSorted list (By Length):");
        words.forEach(System.out::println);
    }
}
