package com.neeson.thread.course4;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * Created by daile on 2017/8/31.
 */
public class FileCrawler implements Runnable {

    private final BlockingQueue<File> fileQueue;

    private final FileFilter fileFilter;

    private final File file;

    public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File file) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            crawl(file);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null){
            for (File entry : entries){
                if (entry.isDirectory())
                    crawl(entry);
                else if (!alreadyIndexed(entry))
                    fileQueue.put(entry);
            }
        }
    }

    private boolean alreadyIndexed(File file){
        return true;
    }

}
