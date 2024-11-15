import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThread {
    public static void main(String[] args) {
        
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "Virtual Thread 1")
                .thenApplyAsync(result -> result.toUpperCase())
                .thenAcceptAsync(uppercaseResult -> {
                    System.out.println("Uppercase result: " + uppercaseResult +
                            " in thread: " + Thread.currentThread().getName());
                });

        future.join(); 

        CompletableFuture<Void> future2 = CompletableFuture
                .supplyAsync(() -> "Virtual Thread 2")
                .thenApplyAsync(result -> result.toUpperCase())
                .thenAcceptAsync(uppercaseResult -> {
                    System.out.println("Uppercase result: " + uppercaseResult +
                            " in thread: " + Thread.currentThread().getName());
                });

        future2.join();

        CompletableFuture<Void> future3 = CompletableFuture
                .supplyAsync(() -> "Virtual Thread 3")
                .thenApplyAsync(result -> result.toUpperCase())
                .thenAcceptAsync(uppercaseResult -> {
                    System.out.println("Uppercase result: " + uppercaseResult +
                            " in thread: " + Thread.currentThread().getName());
                });

        future3.join();

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println("Running task in a virtual thread: " 
                                   + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
