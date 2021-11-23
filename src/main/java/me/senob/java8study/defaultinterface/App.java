package me.senob.java8study.defaultinterface;

import java.util.*;
import java.util.function.Consumer;

public class App {

    public static void main(String[] args) {
        DefaultFoo defaultFoo = new DefaultFoo("senob");
        System.out.println(defaultFoo.getName());
        defaultFoo.printName();
        defaultFoo.printNameUppercase();
        Foo.printAnythings();

        List<String> names = new ArrayList<>(Arrays.asList("seno", "taeho", "donghyun", "youngmin"));

        Consumer<String> s = s1 -> {
            System.out.println("s1 = " + s1);
        };

        names.forEach(s);
        names.forEach(System.out::println);

        System.out.println("-----------------------------");
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("-----------------------------");
        while(spliterator1.tryAdvance(System.out::println));

        names.removeIf(n -> n.startsWith("s"));
        names.forEach(System.out::println);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase);
        names.forEach(System.out::println);

        System.out.println("--------------------------------");
        names.sort(compareToIgnoreCase.reversed());
        names.forEach(System.out::println);
    }
}
