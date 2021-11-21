package me.senob.java8study.methodreference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

public class App {
    public static void main(String[] args) {
        UnaryOperator<String> hi = (s) -> "hi " + s;
        System.out.println(hi.apply("seno"));

        UnaryOperator<String> hiMethodReference = Greeting::hi;
        System.out.println(hiMethodReference.apply("seno"));

        Predicate<String> startsWithSenoPredicate = Greeting::startsWithSeno;
        System.out.println("startsWithSenoPredicate.test(\"senokdfjskdjfks\") = " + startsWithSenoPredicate.test("senokdfjskdjfks"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println("hello.apply(\"seno\") = " + hello.apply("seno"));

        Supplier<Greeting> newGreeting = Greeting::new;
        System.out.println(newGreeting.get().getName());

        Function<String, Greeting> senoGreeting = Greeting::new;
        System.out.println(senoGreeting.apply("seno").getName());

        String[] names = {"teaho", "seno", "youngman", "donghyun"};
//        Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println("names = " + Arrays.toString(names));
    }
}
