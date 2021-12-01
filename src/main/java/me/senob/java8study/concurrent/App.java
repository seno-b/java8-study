package me.senob.java8study.concurrent;

public class App {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> System.out.println("thread run : " + Thread.currentThread().getName()));

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello " + Thread.currentThread().getName());

        thread.start();
    }
}
