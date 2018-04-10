package com.neeson.design.observer.segment04;

import java.util.EventListener;

public interface DbClickListener extends EventListener {
    
    void dbClick(DbClickEvent dbClickEvent);
    
}
