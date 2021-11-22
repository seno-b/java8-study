package me.senob.java8study.defaultinterface;

public class DefaultFoo implements Foo{

    private String name;

    @Override
    public void printName() {
        System.out.println("name = " + this.name);
    }

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
