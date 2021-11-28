package me.senob.java8study.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) {
//        instant();
//        localDateTime();
//        period();
//        duration();
        formatting();
    }

    private static void formatting() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        System.out.println("DateTimeFormatter.ofPattern(\"MM/dd/yyyy\") = " + now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate parseDate = LocalDate.parse("2021/12/25", yyyyMMdd);
        System.out.println("parseDate = " + parseDate);
    }
    
    // 머신용 시간 비교
    private static void duration() {
        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println("between.getSeconds() = " + between.getSeconds());
    }

    private static void period() {
        LocalDate now = LocalDate.now();
        LocalDate myBirthday = LocalDate.of(2022, Month.SEPTEMBER, 16);

        Period period = Period.between(now, myBirthday);
        System.out.println("period = " + period.getDays() + "/" + period.getMonths() + "/" + period.getYears());

        Period until = now.until(myBirthday);
        System.out.println("until = " + until.get(ChronoUnit.DAYS));
    }
    private static void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime birthDay = LocalDateTime.of(1992, Month.SEPTEMBER, 16, 0, 0, 0);
        System.out.println("birthDay = " + birthDay);
        ZonedDateTime nowInJapan = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("nowInJapan = " + nowInJapan);
    }

    private static void instant() {
        Instant now = Instant.now();
        System.out.println("now = " + now);
        System.out.println("now.atZone(ZoneId.systemDefault()) = " + now.atZone(ZoneId.systemDefault()));
    }
}
