package me.senob.java8study.optional;

import me.senob.java8study.stream.OnlineClass;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optionalOnlineClass = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean present = optionalOnlineClass.isPresent(); // present 로 검사 반대는 isEmpty()
        System.out.println("present = " + present);

        if (optionalOnlineClass.isPresent()) {
            OnlineClass onlineClass = optionalOnlineClass.get();
            String title = onlineClass.getTitle();
            System.out.println("title = " + title);
        }
        
        optionalOnlineClass.ifPresent(oc -> System.out.println("oc.getTitle() = " + oc.getTitle()));

        OnlineClass onlineClass = optionalOnlineClass.orElse(createNewClass());
        System.out.println("onlineClass = " + onlineClass.getTitle());

        OnlineClass orGetClass = optionalOnlineClass.orElseGet(App::createNewClass);
        System.out.println("orGetClass = " + orGetClass.getTitle());

        /*OnlineClass orElseThrow = optionalOnlineClass.orElseThrow();
        System.out.println("orElseThrow = " + orElseThrow.getTitle());

        OnlineClass orElseCreateThrow = optionalOnlineClass.orElseThrow(IllegalArgumentException::new);
        System.out.println("orElseThrow = " + orElseThrow.getTitle());*/

        Optional<OnlineClass> optionalOnlineClass1 = optionalOnlineClass.filter(OnlineClass::isClosed);
        System.out.println("optionalOnlineClass1 = " + optionalOnlineClass1.isPresent());

        Optional<Integer> optionalInteger = optionalOnlineClass.map(oc -> oc.getId());
        System.out.println("optionalInteger.isPresent() = " + optionalInteger.isPresent());

        Optional<Optional<Progress>> progress = optionalOnlineClass.map(oc -> oc.getProgress());

        Optional<Progress> progress1 = optionalOnlineClass.flatMap(oc -> oc.getProgress());
        Progress progress2 = progress1.orElseThrow();
    }

    private static OnlineClass createNewClass() {
        System.out.println("create things");
        return new OnlineClass(10, "new Class", false);
    }
}
