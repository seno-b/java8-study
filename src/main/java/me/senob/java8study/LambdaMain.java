package me.senob.java8study;

import java.util.function.Function;
import java.util.function.IntFunction;

public class LambdaMain {
    public static void main(String[] args) {

        LambdaMain lambdaMain = new LambdaMain();
        lambdaMain.run();
    }

    private void run() {
        Integer baseNumber = 10;

        // lambda 의 scope는 LambdaMain Class 와 동일하게 적용되므로 run 메서드 안에 있는 baseNumber로 인자를 받으면 안됨.
        Function<Integer, Integer> sum = (i) -> i + baseNumber;

        // inner class는 scope가 다르기 때문에 인스턴스 메서드 또는 변수 생성시 run 메서드의 baseNumber의 이름을 사용할 수 있다.
        class localClass {
            public Integer getBaseNumber(Integer baseNumber) {
                return baseNumber;
            }
        }

        // 익명클래스도 동일
        IntFunction resultInt = new IntFunction() {
            @Override
            public Object apply(int value) {
                return baseNumber;
            }
        };

    }
}
