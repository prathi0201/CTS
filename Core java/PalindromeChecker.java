import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palindrome Checker");
        System.out.println("------------------");
        System.out.print("Enter a string: ");
        String originalString = scanner.nextLine();
        String cleanedString = originalString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedString = new StringBuilder(cleanedString).reverse().toString();
        boolean isPalindrome = cleanedString.equals(reversedString);
        if (isPalindrome) {
            System.out.println("'" + originalString + "' is a palindrome.");
        } else {
            System.out.println("'" + originalString + "' is NOT a palindrome.");
        }
        scanner.close();
    }
}
