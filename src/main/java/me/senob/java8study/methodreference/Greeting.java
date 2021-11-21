package me.senob.java8study.methodreference;

public class Greeting {

    private String name;

    public Greeting() {

    }

    public Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name){
        return "hi " + name;
    }

    public static boolean startsWithSeno(String searchName) {
        return searchName.startsWith("seno");
    }
}
