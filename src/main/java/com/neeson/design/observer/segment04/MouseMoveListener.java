package com.neeson.design.observer.segment04;

import java.util.EventListener;

public interface MouseMoveListener extends EventListener {
    
    void mouseMove(MouseMoveEvent mouseMoveEvent);
    
}
