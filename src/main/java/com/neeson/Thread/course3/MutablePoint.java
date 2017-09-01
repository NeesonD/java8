package com.neeson.Thread.course3;

import com.neeson.Thread.annotation.NotThreadSafe;

/**
 * Created by daile on 2017/8/30.
 */
@NotThreadSafe
public class MutablePoint {

    public int x,y;

    public MutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MutablePoint(MutablePoint p){
        this.x = p.x;
        this.y = p.y;
    }
}
