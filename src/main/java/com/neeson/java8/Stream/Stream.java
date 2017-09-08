package com.neeson.java8.Stream;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by daile on 2017/9/4.
 */
public class Stream {

    public static void main(String[] args) {

        List<Integer> nums = Lists.newArrayList(1,2,3,7,6,3,null);
        List<Integer> integers = Arrays.asList(1, 2, 3);
        nums.stream().filter(num -> num != null)
                .distinct()
                .mapToInt(num -> num*2)
                .skip(1)
                .limit(4)
                .sorted().peek(System.out::println).sum();


        List<Integer> numWithoutNull = nums.stream().filter(num -> num!= null)
                .collect(() -> new ArrayList<Integer>(),
                        (list,item) -> list.add(item),
                        (list1,list2) -> list1.addAll(list2));
    }

}
