package com.neeson.Thread.course3;

import com.neeson.domain.KeyListener;
import com.neeson.domain.MouseListener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by daile on 2017/8/30.
 */
public class VisualComponent<T> {

    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();

    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();

    private final List<T> tList = new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener listener){
        keyListeners.add(listener);
    }

    public void addMouselistener(MouseListener listener){
        mouseListeners.add(listener);
    }

    public void removeKeyListener(KeyListener listener){
        keyListeners.remove(listener);
    }

    public void removeMouseListener(MouseListener listener){
        mouseListeners.remove(listener);
    }

    public void addListener(T t){
        tList.add(t);
    }


}
