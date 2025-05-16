package com.ivatolm.sem6.awaitility;

import org.junit.jupiter.api.*;
import java.util.concurrent.*;
import static org.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.*;
import static org.junit.jupiter.api.Assertions.*;

public class AsyncServiceTest {

    private AsyncService service;

    @BeforeEach
    void setup() {
        service = new AsyncService();
    }

    @AfterEach
    void cleanup() {
        service.shutdown();
    }

    @Test
    void testTask1CompletesInTime() {
        CompletableFuture<String> future = service.task1();

        await()
            .atMost(2, SECONDS)
            .until(future::isDone);

        assertTrue(future.isDone());
        assertFalse(future.isCompletedExceptionally());
        System.out.println(future.join());
    }

    @Test
    void testTask2CompletesInTime() {
        CompletableFuture<String> future = service.task2();

        await()
            .atMost(3, SECONDS)
            .until(future::isDone);

        assertTrue(future.isDone());
        assertFalse(future.isCompletedExceptionally());
        System.out.println(future.join());
    }

    @Test
    void testTask3() {
        CompletableFuture<String> success = CompletableFuture.supplyAsync(() -> "Ok");
        CompletableFuture<String> failure = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Fail");
        });
        CompletableFuture<String> future = service.task3(success, failure);

        await()
            .atMost(3, SECONDS)
            .until(future::isDone);

        assertTrue(future.isDone());
        assertTrue(future.isCompletedExceptionally());
        System.out.println("Task 3 failed");
    }

}
