package me.senob.java8study.defaultinterface;

public interface Foo {

    void printName();

    default void printNameUppercase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    static void printAnythings() {
        System.out.println("bla bla bla");
    }
}
