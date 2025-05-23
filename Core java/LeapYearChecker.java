import java.util.Scanner;
public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Leap Year Checker");
        System.out.println("-----------------");
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        boolean isLeapYear;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }
        if (isLeapYear) {
            System.out.println(year + " is a LEAP YEAR.");
        } else {
            System.out.println(year + " is NOT a leap year.");
        }
        scanner.close();
    }
}
