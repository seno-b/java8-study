package me.senob.java8study;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {

        // function interface를 직접 만들지 않아도. 이미 구현 되어 있다.
        // import java.util.function.Function;
        Plus10 plus10 = new Plus10();
        Integer apply = plus10.apply(10);
        System.out.println("apply = " + apply);

        Function<Integer, Integer> plus5 = (i) -> i + 5;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        // compose
        // function 앞에 function 붙여서 실행
        System.out.println("plus5.compose = " + plus5.compose(multiply2).apply(5));

        // andThen
        // function 뒤에 function 붙여서 실행
        System.out.println("plus5.andThen = " + plus5.andThen(multiply2).apply(5));

        // BiFunction<T, U, R>
        // 인자값이 두개고 한개를 리턴해주는 함수 인터페이스
        BiFunction<Integer, String, String> stringSplitAddInteger = (i, s) -> s + i.toString();
        System.out.println(stringSplitAddInteger.apply(10, "여기 뒤에 붙여줘 "));

        // Consumer<T>
        // 인자값이 하나이고 아무것도 리턴하지 않는 함수 인터페이스
        Consumer<String> outputMessage = (s) -> System.out.println(s);
        outputMessage.accept("testjkatkasjfkd");

        // Supplier<T>
        // T타입의 값을 제공하는 인터페이스
        Supplier<String> getCode = () -> "CD_1";
        System.out.println(getCode.get());


        // Predicate<T>
        // T타입의 인자를 받아 boolean 형태로 리턴해주는 함수형 인터페이스
        Predicate<String> startsWithSeno = (s) -> s.startsWith("seno");
        System.out.println(startsWithSeno.test("sssno"));
        System.out.println(startsWithSeno.test("seno"));
    }
}
