package com.neeson.Thread.course6.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by daile on 2017/9/1.
 */
public class FutureRender {

    private final ExecutorService executorService = new ExecutorService() {
        @Override
        public void shutdown() {

        }

        @Override
        public List<Runnable> shutdownNow() {
            return null;
        }

        @Override
        public boolean isShutdown() {
            return false;
        }

        @Override
        public boolean isTerminated() {
            return false;
        }

        @Override
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            return null;
        }

        @Override
        public <T> Future<T> submit(Runnable task, T result) {
            return null;
        }

        @Override
        public Future<?> submit(Runnable task) {
            return null;
        }

        @Override
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            return null;
        }

        @Override
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
            return null;
        }

        @Override
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            return null;
        }

        @Override
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }

        @Override
        public void execute(Runnable command) {

        }
    };

    void renderPage(CharSequence sequence){
        final List<ImageInfo> imageInfos = scanPorForImageInfo(sequence);
        Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
            @Override
            public List<ImageData> call() throws Exception {
                List<ImageData> result= new ArrayList<>();
                for (ImageInfo imageInfo:imageInfos){
                    result.add(imageInfo.downloadimage());
                }
                    return result;
            }
        };
        Future<List<ImageData>> future = executorService.submit(task);
        renderText(sequence);

        try {
            List<ImageData> imageData = future.get();
            for (ImageData data:imageData){
                renderImage(data);
            }
        }catch (InterruptedException e){
            Thread.interrupted();
            future.cancel(true);
        }catch (ExecutionException e){

        }

    }

    private void renderImage(ImageData data) {
    }

    private void renderText(CharSequence sequence) {
    }

    private List<ImageInfo> scanPorForImageInfo(CharSequence sequence) {
        return null;
    }

}
