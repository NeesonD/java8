package com.neeson.Thread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/4
 * Time: 10:55
 * Description:
 */
public class ArrayListTest {

    public static final List<Integer> list = new ArrayList<>();

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            EXECUTOR_SERVICE.execute(() ->{
                list.add(new Random().nextInt(100));
            });
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.size());
        }
        EXECUTOR_SERVICE.shutdown();
    }

}
