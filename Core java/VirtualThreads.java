import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;
public class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of threads to create (e.g., 100000): ");
        int numThreads = scanner.nextInt();      
        System.out.println("\n=== Testing Virtual Threads ===");
        testThreads(numThreads, true);       
        System.out.println("\n=== Testing Platform Threads ===");
        System.out.println("Warning: Creating many platform threads may crash your system!");
        System.out.print("Do you want to proceed with platform threads test? (y/n): ");        
        if (scanner.next().equalsIgnoreCase("y")) {
            testThreads(Math.min(numThreads, 10000), false); // Limiting platform threads for safety
        }      
        scanner.close();
    }    
    private static void testThreads(int numThreads, boolean useVirtualThreads) throws InterruptedException {
        Instant start = Instant.now();
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            final int threadNum = i + 1;
            Runnable task = () -> {
                try {
                    Thread.sleep(100);
                    System.out.println((useVirtualThreads ? "Virtual" : "Platform") +
                                       " Thread " + threadNum + " completed");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            };          
            if (useVirtualThreads) {
                threads[i] = Thread.startVirtualThread(task);
            } else {
                threads[i] = new Thread(task);
                threads[i].start();
            }
        }
        for (Thread thread : threads) {
            thread.join();
        }     
        Duration duration = Duration.between(start, Instant.now());
        System.out.println("\n" + (useVirtualThreads ? "Virtual" : "Platform") +
                           " Threads Summary:");
        System.out.println("Number of threads: " + numThreads);
        System.out.println("Total time: " + duration.toMillis() + " ms");
        System.out.println("Memory used: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " MB");
    }
}
