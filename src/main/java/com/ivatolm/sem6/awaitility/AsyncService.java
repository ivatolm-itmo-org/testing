package com.ivatolm.sem6.awaitility;

import java.util.Random;
import java.util.concurrent.*;

public class AsyncService {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    private final Random random = new Random();

    public CompletableFuture<String> task1() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int delay = 500 + random.nextInt(1000);
                Thread.sleep(delay);
                return "Task 1: finished in " + delay + "ms";
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted", e);
            }
        }, executor);
    }

    public CompletableFuture<String> task2() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int delay = 1000 + random.nextInt(1000);
                Thread.sleep(delay);
                return "Task 2: finished in " + delay + "ms";
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted", e);
            }
        }, executor);
    }

    public CompletableFuture<String> task3(CompletableFuture<String> future1, CompletableFuture<String> future2) {
        return CompletableFuture.allOf(future1, future2).thenApplyAsync(v -> {
            return "Task3: finished";
        }, executor);
    }

    public void shutdown() {
        executor.shutdownNow();
    }
}
