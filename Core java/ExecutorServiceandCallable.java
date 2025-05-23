import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tasks to execute: ");
        int numTasks = scanner.nextInt();s
        ExecutorService executor = Executors.newFixedThreadPool(numTasks);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < numTasks; i++) {
            System.out.print("Enter input value for task " + (i + 1) + ": ");
            int input = scanner.nextInt();
            Callable<Integer> task = new MyCallable("Task-" + (i + 1), input);
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }
        executor.shutdown();
        System.out.println("\nTask Results:");
        for (int i = 0; i < futures.size(); i++) {
            try {
                Integer result = futures.get(i).get();
                System.out.println("Task " + (i + 1) + " result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Task " + (i + 1) + " failed: " + e.getMessage());
            }
        }
        scanner.close();
    }
    static class MyCallable implements Callable<Integer> {
        private final String name;
        private final int input;      
        public MyCallable(String name, int input) {
            this.name = name;
            this.input = input;
        }   
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return input * input;
        }
    }
}
