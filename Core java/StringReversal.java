import java.util.Scanner;
public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("String Reversal Program");
        System.out.println("-----------------------");
        System.out.print("Enter a string to reverse: ");
        String originalString = scanner.nextLine();
        StringBuilder reversedStringBuilder = new StringBuilder(originalString);
        reversedStringBuilder.reverse();
        String reversedString = reversedStringBuilder.toString();
        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
        scanner.close();
    }
}
