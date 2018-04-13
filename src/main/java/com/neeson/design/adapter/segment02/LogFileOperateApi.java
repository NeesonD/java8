package com.neeson.design.adapter.segment02;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/13
 * Time: 9:33
 * Description:
 */
public interface LogFileOperateApi {

    List<LogBean> readLogFile();

    void writeLogFile(List<LogBean> logBeans);
}
