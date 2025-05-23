import java.util.*;
import java.util.stream.Collectors;
record Person(String name, int age) {}
public class PersonRecordDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        System.out.print("How many people do you want to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter name of person " + i + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter age of person " + i + ": ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            people.add(new Person(name, age));
        }
        System.out.println("\nAll People:");
        people.forEach(System.out::println);
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .collect(Collectors.toList());
        System.out.println("\nPeople aged 18 and above:");
        adults.forEach(System.out::println);
    }
}
