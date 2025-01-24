package com.ciptadana.bareksaapi.util;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
public class AsyncUtil {

    // Execute a batch of Runnable tasks with a specified executor
    public CompletableFuture<Void> runAsync(Collection<? extends Runnable> tasks, Executor executor) {
        List<CompletableFuture<Void>> futures = tasks.stream()
                .map(task -> CompletableFuture.runAsync(task, executor))
                .toList();
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    // Execute a single Runnable task with a specified executor
    public CompletableFuture<Void> runAsync(Runnable task, Executor executor) {
        return CompletableFuture.runAsync(task, executor);
    }

    // Execute a batch of Supplier tasks with a specified executor, returning a list of results
    public <T> CompletableFuture<List<T>> supplyAsync(Collection<? extends Supplier<T>> tasks, Executor executor) {
        List<CompletableFuture<T>> futures = tasks.stream()
                .map(task -> CompletableFuture.supplyAsync(task, executor))
                .toList();
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }

    // Execute a single Supplier task with a specified executor, returning the result
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> task, Executor executor) {
        return CompletableFuture.supplyAsync(task, executor);
    }
}

