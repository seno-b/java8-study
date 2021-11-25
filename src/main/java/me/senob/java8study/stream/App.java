package me.senob.java8study.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

//        streamTest1();
        streamTest2();
    }

    private static void streamTest2() {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream().filter(o -> o.getTitle().startsWith("spring"))
            .forEach(o -> System.out.println(o.getTitle()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed))
                .forEach(o -> System.out.println(o.getTitle()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(OnlineClass::getTitle)
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> senoEvents = new ArrayList<>();
        senoEvents.add(springClasses);
        senoEvents.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        senoEvents.stream().flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 뺴고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("test"));
        System.out.println("test = " + test);

        System.out.println("스프링 수업중에 제목에 spring 이 들어간 제목만 모아서 List로 만들기");
        List<String> titleInSpringList = springClasses.stream().filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
    }

    private static void streamTest1() {
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
