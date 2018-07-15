package com.neeson.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/3/17
 * Time: 18:06
 * Description:
 */
public class TimeTest {

    public static void main(String[] args) {
        // new TimeTest().run();
        //new TimeTest().run2();

        new TimeTest().getTime();

    }

    void getTime() {
        long l = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8));
        System.out.println(Instant.now());
        System.out.println(LocalDateTime.now().plus(1, ChronoUnit.HOURS));
        System.out.println(l);
        System.out.println(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli() / 1000);
    }


    void getUTCTime() {
        String s = LocalDateTime.now().minusDays(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));

        System.out.println(s);
    }

    void testTimestamp() {
        long t = 1520576779000L;
        Date date = new Date(t);
        System.out.println(date);
    }

    public void UDateToLocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 02. java.util.Date --> java.time.LocalDate
     */
    public void UDateToLocalDate() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    public void UDateToLocalTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public void LocalDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public void LocalDateToUdate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public void LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }

    void run3() {
        LocalDate date = LocalDate.now();
        LocalDate now = LocalDate.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("YY:MM:dd")));
        System.out.println(now);

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1.format(DateTimeFormatter.ofPattern("yy~mm~dd hh:mm:ss")));

        Instant now2 = Instant.now();
        System.out.println(now2);
    }

    void run2() {

        LocalDate today = LocalDate.now();

        //Get the Year, check if it's leap year
        System.out.println("Year " + today.getYear() + " is Leap Year? " + today.isLeapYear());

        //Compare two LocalDate for before and after
        System.out.println("Today is before 01/01/2015? " + today.isBefore(LocalDate.of(2015, 1, 1)));

        //Create LocalDateTime from LocalDate
        System.out.println("Current Time=" + today.atTime(LocalTime.now()));

        //plus and minus operations
        System.out.println("10 days after today will be " + today.plusDays(10));
        System.out.println("3 weeks after today will be " + today.plusWeeks(3));
        System.out.println("20 months after today will be " + today.plusMonths(20));

        System.out.println("10 days before today will be " + today.minusDays(10));
        System.out.println("3 weeks before today will be " + today.minusWeeks(3));
        System.out.println("20 months before today will be " + today.minusMonths(20));

        //Temporal adjusters for adjusting the dates
        System.out.println("First date of this month= " + today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year= " + lastDayOfYear);

        Period period = today.until(lastDayOfYear);
        System.out.println("Period Format= " + period);
        System.out.println("Months remaining in the year= " + period.getMonths());
    }

    void run() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalTime localTime = currentTime.toLocalTime();
        int year = currentTime.getYear();
        Month month = currentTime.getMonth();
        int dayOfYear = currentTime.getDayOfYear();
        int dayOfMonth = currentTime.getDayOfMonth();
        DayOfWeek dayOfWeek = currentTime.getDayOfWeek();
        System.out.println(currentTime);
        System.out.println(currentTime.toLocalDate());
        System.out.println(localTime);
        System.out.println(year);
        System.out.println(month);
        System.out.println(dayOfYear);
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);

    }

}
