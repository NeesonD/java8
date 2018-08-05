package com.neeson.Thread.course9;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daile on 2017/9/11.
 */
public class BetterAttributeStore {

    private final Map<String,String> attributes = new HashMap<>();

    public boolean userLocationMatches(String name, String regexp){
        String key = name;
        String location;
        synchronized (this){
            location = attributes.get(key);
        }
        if (location == null)
            return false;
        else
            return true;
    }

}
