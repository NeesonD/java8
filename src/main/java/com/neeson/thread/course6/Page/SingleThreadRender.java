package com.neeson.thread.course6.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daile on 2017/9/1.
 */
public class SingleThreadRender {

    void readerPage(CharSequence source){
        renderText(source);
        List<ImageData> imageData = new ArrayList<>();
        for (ImageData imageinfo:imageData){
            imageData.add(imageinfo.downloadImage());
        }
        for (ImageData data:imageData){
            renderImage(data);
        }
    }

    private void renderImage(ImageData data) {
    }

    private void renderText(CharSequence source) {
    }

}
