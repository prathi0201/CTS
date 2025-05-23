import java.util.Scanner;
public class AnimalDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Animal Creator");
        System.out.println("1. Create generic Animal");
        System.out.println("2. Create Dog");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Animal animal;
        if (choice == 1) {
            System.out.print("Enter the sound this animal makes: ");
            String sound = scanner.nextLine();
            animal = new Animal(sound);
        } else if (choice == 2) {
            System.out.print("Enter the dog's name: ");
            String name = scanner.nextLine();
            animal = new Dog(name);
        } else {
            System.out.println("Invalid choice. Creating a generic Animal.");
            animal = new Animal("Some sound");
        }
        System.out.println("\nAnimal Information:");
        animal.makeSound();
        if (animal instanceof Dog) {
            System.out.println("This is a dog named: " + ((Dog)animal).getName());
        }
        scanner.close();
    }
}
class Animal {
    private String sound;
    public Animal(String sound) {
        this.sound = sound;
    }
    public void makeSound() {
        System.out.println("The animal makes sound: " + sound);
    }
    public String getSound() {
        return sound;
    }
}
class Dog extends Animal {
    private String name;
    public Dog(String name) {
        super("Bark");
        this.name = name;
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says: Bark!");
    }
    public String getName() {
        return name;
    }
}
