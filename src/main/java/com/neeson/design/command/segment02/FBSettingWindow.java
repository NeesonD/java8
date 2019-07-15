package com.neeson.design.command.segment02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 9:55
 * Description:
 */
public class FBSettingWindow {

    private String title;
    private List<FunctionButton> functionButtons = new ArrayList<>();

    public FBSettingWindow(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addFunctionButton(FunctionButton functionButton){
        functionButtons.add(functionButton);
    }

    public void removeFunctionButton(FunctionButton functionButton){
        functionButtons.remove(functionButton);
    }

    public void dispaly(){
        for(FunctionButton functionButton:functionButtons){
            System.out.println(functionButton.getName());
        }
    }

}
