.import java.util.Scanner;
class MessagePrinterThread extends Thread {
    private String message;
    public MessagePrinterThread(String message) {
        this.message = message;
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - Count: " + i + " (Thread: " + Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e);
            }
        }
    }
}
class MessagePrinterRunnable implements Runnable {
    private String message;
    public MessagePrinterRunnable(String message) {
        this.message = message;
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - Count: " + i + " (Thread: " + Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter message for Thread class: ");
        String msg1 = scanner.nextLine();
        System.out.print("Enter message for Runnable class: ");
        String msg2 = scanner.nextLine();
        MessagePrinterThread thread1 = new MessagePrinterThread(msg1);
        Thread thread2 = new Thread(new MessagePrinterRunnable(msg2));
        thread1.start();
        thread2.start();
    }
}
