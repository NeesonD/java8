package com.neeson.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by daile on 2017/9/2.
 */
public class StringSort {

    List<String> names = Arrays.asList("peter", "anna", "mike");

    public void sort() {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void sortLbd() {
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }

}
