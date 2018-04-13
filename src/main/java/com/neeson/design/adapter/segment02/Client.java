package com.neeson.design.adapter.segment02;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/13
 * Time: 9:40
 * Description:
 */
public class Client {

    public static void main(String[] args) {
        LogBean logBean = new LogBean();
        logBean.setLogId("1");
        logBean.setUserId("neeson");
        LogDbOpeApi logDbOpeApi = new LogAdapter(new LogFileOperate("file.log"));
        logDbOpeApi.createLog(logBean);
    }

}
