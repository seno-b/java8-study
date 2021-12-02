package me.senob.java8study.concurrent;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            int a = 0;
            while(true){
                a++;
                System.out.println(Thread.currentThread().getName() + "thread count : " + a);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    return ;
                }
            }

        });

        thread.start();

        System.out.println("dlkdkdkdkd");
        Thread.sleep(3000L);
        thread.interrupt();

    }
}
