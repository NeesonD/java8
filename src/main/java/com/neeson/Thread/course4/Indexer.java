package com.neeson.Thread.course4;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by daile on 2017/8/31.
 */
public class Indexer implements Runnable {

    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true)
                indexFile(queue.take());
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void indexFile(File file){

    }
}
