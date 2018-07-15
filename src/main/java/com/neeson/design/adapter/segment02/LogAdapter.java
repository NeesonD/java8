package com.neeson.design.adapter.segment02;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/13
 * Time: 9:38
 * Description:
 */
public class LogAdapter implements LogDbOpeApi {

    private LogFileOperate adaptee;

    public LogAdapter(LogFileOperate adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void createLog(LogBean logBean) {
        List<LogBean> logBeans = adaptee.readLogFile();
        logBeans.add(logBean);
        adaptee.writeLogFile(logBeans);
    }
}
