package com.neeson.design.adapter.segment02;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/13
 * Time: 9:35
 * Description:
 */
public class LogFileOperate  implements  LogFileOperateApi{

    private String logFileName = "file.log";

    public LogFileOperate(String logFileName) {
        this.logFileName = logFileName;
    }

    @Override
    public List<LogBean> readLogFile() {
        return null;
    }

    @Override
    public void writeLogFile(List<LogBean> logBeans) {

    }
}
