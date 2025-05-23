import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class SimpleDecompileDemo {
    private String name;
    private int age;
    public SimpleDecompileDemo(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Object created for " + name + " (Age: " + age + ")");
    }
    public String greet(String string) {
        String string2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return "Hello " + string + "! This is " + this.name + " saying hi at " + string2 + ".";
    }
    public void displayInfo() {
        if (this.age < 18) {
            System.out.println(this.name + " is a minor.");
        } else {
            System.out.println(this.name + " is an adult.");
        }
    }
    public static void main(String[] arrstring) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String string = scanner.nextLine();
        System.out.print("Enter your age: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        SimpleDecompileDemo simpleDecompileDemo = new SimpleDecompileDemo(string, n);
        System.out.print("Enter a name to greet: ");
        String string2 = scanner.nextLine();
        String string3 = simpleDecompileDemo.greet(string2);
        System.out.println(string3);
        simpleDecompileDemo.displayInfo();
        scanner.close();
        System.out.println("Program finished.");
    }
}
