import java.util.Scanner;
public class MusicPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Music Instrument Player");
        System.out.println("1. Play Guitar");
        System.out.println("2. Play Piano");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Playable instrument;
        if (choice == 1) {
            System.out.print("Enter guitar type (e.g., Acoustic, Electric): ");
            String guitarType = scanner.nextLine();
            instrument = new Guitar(guitarType);
        } else if (choice == 2) {
            System.out.print("Enter piano brand (e.g., Yamaha, Steinway): ");
            String pianoBrand = scanner.nextLine();
            instrument = new Piano(pianoBrand);
        } else {
            System.out.println("Invalid choice. Defaulting to Acoustic Guitar.");
            instrument = new Guitar("Acoustic");
        }
        System.out.println("\nPlaying the instrument:");
        instrument.play();
        if (instrument instanceof Guitar) {
            System.out.println("Guitar type: " + ((Guitar)instrument).getType());
        } else if (instrument instanceof Piano) {
            System.out.println("Piano brand: " + ((Piano)instrument).getBrand());
        }
        scanner.close();
    }
}
interface Playable {
    void play();
}
class Guitar implements Playable {
    private String type;
    public Guitar(String type) {
        this.type = type;
    }
    @Override
    public void play() {
        System.out.println("Strumming the " + type + " guitar: ♫ ♬ ♪");
    }
    public String getType() {
        return type;
    }
}
class Piano implements Playable {
    private String brand;
    public Piano(String brand) {
        this.brand = brand;
    }
    @Override
    public void play() {
        System.out.println("Playing the " + brand + " piano: ♩ ♫ ♬ ♭");
    }
    public String getBrand() {
        return brand;
    }
}
