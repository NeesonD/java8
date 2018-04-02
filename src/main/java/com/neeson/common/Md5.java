package com.neeson.common;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/3/29
 * Time: 17:52
 * Description:
 */
public class Md5 {

    public static void main(String[] args) {
        String s = DigestUtils.md5Hex("/video/standard/1K.html-1444435200-0-0-aliyuncdnexp1234");
        System.out.println(s);
    }

}
