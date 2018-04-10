package com.neeson.design.observer.segment04;

import java.util.EventListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/10
 * Time: 8:15
 * Description:
 */
public interface ClickListener extends EventListener {
    
    void click(ClickEvent clickEvent);
    
}
