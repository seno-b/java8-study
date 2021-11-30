package me.senob.java8study.concurrent;

public class App {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable : " + Thread.currentThread().getName());
            }
        });

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello " + Thread.currentThread().getName());

        thread.start();
    }
}
