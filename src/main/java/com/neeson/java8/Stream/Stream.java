package com.neeson.java8.Stream;


import com.google.common.collect.Lists;
import com.neeson.java8.lambda.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by daile on 2017/9/4.
 */
public class Stream {

    public static void main(String[] args) {

        new Stream().run();

    }

    void run() {
        // test1();
        test2();
    }

    void test2() {
        List<Person> people = new ArrayList<>();
       /* people.add(new Person(4));
        people.add(new Person(3));
        people.add(new Person(5));*/
        OptionalDouble average = people.stream().mapToInt(p -> p.getAge()).average();
        if (average.isPresent()) {
            double asDouble = average.getAsDouble();
            System.out.println(asDouble);
        }
    }

    void test1() {
        List<Integer> nums = Lists.newArrayList(1, 2, 3, 7, 6, 3, null);
        List<Integer> integers = Arrays.asList(1, 2, 3);
        nums.stream().filter(num -> num != null)
                .distinct()
                .mapToInt(num -> num * 2)
                .skip(1)
                .limit(4)
                .sorted().peek(System.out::println).sum();


        List<Integer> numWithoutNull = nums.stream().filter(num -> num != null)
                .collect(() -> new ArrayList<Integer>(),
                        (list, item) -> list.add(item),
                        (list1, list2) -> list1.addAll(list2));
    }

}
