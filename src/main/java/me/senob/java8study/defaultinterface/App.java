package me.senob.java8study.defaultinterface;

public class App {

    public static void main(String[] args) {
        DefaultFoo defaultFoo = new DefaultFoo("senob");
        System.out.println(defaultFoo.getName());
        defaultFoo.printName();
        defaultFoo.printNameUppercase();
        Foo.printAnythings();
    }
}
