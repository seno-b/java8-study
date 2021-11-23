package me.senob.java8study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("senob");
        names.add("teaho");
        names.add("hani");
        names.add("donghyun");

        List<String> toUpperList = names.stream().map((s) -> s.toUpperCase())
                .collect(Collectors.toList());

        toUpperList.stream().forEach(System.out::println);

        System.out.println("-----------------------------");

        names.forEach(System.out::println);

        Set<String> collect = names.parallelStream().map(s -> {
            System.out.println("s = " + s + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toSet());

        collect.forEach(System.out::println);
    }
}
