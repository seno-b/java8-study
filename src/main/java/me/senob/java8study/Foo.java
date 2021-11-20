package me.senob.java8study;

public class Foo {
    public static void main(String[] args) {

        int result = 0;

        RunSomething runSomething = (a) -> {
            return a + 10;
        };

        System.out.println("runSomething = " + runSomething.doIt(100));
        System.out.println("runSomething = " + runSomething.doIt(100));
        System.out.println("runSomething = " + runSomething.doIt(100));
        System.out.println("runSomething = " + runSomething.doIt(100));
    }
}
