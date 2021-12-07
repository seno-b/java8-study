package me.senob.java8study.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
