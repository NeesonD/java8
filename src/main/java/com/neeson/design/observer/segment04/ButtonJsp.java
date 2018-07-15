package com.neeson.design.observer.segment04;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/10
 * Time: 8:36
 * Description:
 */
public class ButtonJsp {

    private Button button;

    public ButtonJsp() {
        super();
        Button button = new Button();
        button.setId("submitButton");
        button.setValue("提交");
        button.setClickListener(clickEvent -> System.out.println("单击事件"));
        button.setDbClickListener(dbClickEvent -> System.out.println("双击事件"));
        button.setMouseMoveListener(mouseMoveEvent -> System.out.println("鼠标移动事件"));
    }

    public Button getButton() {
        return button;
    }
}
