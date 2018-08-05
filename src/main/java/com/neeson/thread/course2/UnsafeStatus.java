package com.neeson.thread.course2;

/**
 * Created by daile on 2017/8/28.
 */
public class UnsafeStatus {


    //status逸出了自己的作用域
    private String[] status = new String[]{
            "a","b"
    };

    public String[] getStatus(){
        return status;
    }

}
