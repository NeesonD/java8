package com.neeson.Thread.course6.Page;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by daile on 2017/9/1.
 */
public class Render {

    private final ExecutorService executor;

    public Render(ExecutorService executor) {
        this.executor = executor;
    }

    void reanderPage(CharSequence sequence){
        List<ImageInfo> infos = scanPorForImageInfo(sequence);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(executor);
        for (final ImageInfo imageInfo:infos){
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadimage();
                }
            });
            renderText(sequence);
            try {
                for (int t = 0,n = infos.size();t<n;t++){
                    Future<ImageData> f = completionService.take();
                    ImageData imageData = f.get();
                    renderImage(imageData);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){

            }
        }
    }


    private List<ImageInfo> scanPorForImageInfo(CharSequence sequence) {
        return null;
    }
    private void renderText(CharSequence sequence) {
    }

    private void renderImage(ImageData data) {
    }
}
