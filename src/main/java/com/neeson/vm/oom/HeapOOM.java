package com.neeson.vm.oom;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/8/3
 * Time: 0:14
 * Description: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = Lists.newArrayList();
        while (true){
            list.add(new OOMObject());
        }
    }

}
