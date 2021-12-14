package me.senob.java8study.excutor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(3000L);
            return "HELLO";
        };

        System.out.println(" Started!! " );
        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        helloFuture.cancel(true);
        String s = helloFuture.get();

        System.out.println(helloFuture.isDone());
        System.out.println(" End!! " );
        executorService.shutdownNow();*/

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<String> hello = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000L);
                return "HELLO";
            }
        };

        Callable<String> seno = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000L);
                return "SENO";
            }
        };

        Callable<String> work = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000L);
                return "WORK";
            }
        };

//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, seno, work));
//        for (Future<String> future : futures) {
//            System.out.println("future = " + future.get());
//        }

        String s = executorService.invokeAny(Arrays.asList(hello, seno, work));
        System.out.println("s = " + s);
    }

    private static Runnable getRunnable(String message) {
        return () -> {
            System.out.println(message + " " + Thread.currentThread().getName());
        };
    }
}
