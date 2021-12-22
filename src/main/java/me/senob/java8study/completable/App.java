package me.senob.java8study.completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "World";
        });

//        CompletableFuture<String> composeFuture = hello.thenCompose(s -> getWorld(s));
//        System.out.println("composeFuture.get() = " + composeFuture.get());

//        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
//        System.out.println("future.get() = " + future.get());

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(hello, world).thenAccept((s) -> {
//            System.out.println("args = " + s);
//        });

//        System.out.println("voidCompletableFuture.get() = " + voidCompletableFuture.get());

//        List<CompletableFuture<String>> completableFutures = Arrays.asList(hello, world);
//
//        CompletableFuture<List<String>> results = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]))
//                .thenApply(v -> completableFutures.stream()
//                        .map(CompletableFuture::join)
//                        .collect(Collectors.toList()));
//
//        List<String> futures = results.get();
//        futures.forEach(System.out::println);


//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
//        System.out.println("voidCompletableFuture.get() = " + voidCompletableFuture.get());

        extractCompletableFutureExceptionally();
    }

    private static void extractCompletableFutureExceptionally() throws ExecutionException, InterruptedException {
        boolean throwError = true;

        /*CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally((ex) -> {
            System.out.println("ex = " + ex);
            return "Error!!";
        });*/

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("ex = " + ex);
            }
            return result;
        });
        System.out.println("future = " + future.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return message + " World";
        });
    }
}
