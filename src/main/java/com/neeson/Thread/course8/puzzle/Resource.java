package com.neeson.Thread.course8.puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by daile on 2017/9/8.
 */
public class Resource {

    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resource.class.getResourceAsStream("Resource.class");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        try {
            while ((line = reader.readLine()) != null)
            stringBuffer.append(line);
        }catch (Exception e){

        }
        System.out.println(stringBuffer.toString());
    }

}
