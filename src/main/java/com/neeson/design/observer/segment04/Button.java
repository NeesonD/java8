package com.neeson.design.observer.segment04;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/10
 * Time: 8:32
 * Description:
 */
@Data
public class Button {

    private String id;

    private String value;

    private ClickListener clickListener;

    private DbClickListener dbClickListener;

    private MouseMoveListener mouseMoveListener;

    public void click(){
        clickListener.click(new ClickEvent(this));
    }

    public void dbClick(){
        dbClickListener.dbClick(new DbClickEvent(this));
    }

    public void mouseMove(){
        mouseMoveListener.mouseMove(new MouseMoveEvent(this));
    }



}
