package com.neeson.thread.semaphore;

import java.util.concurrent.Semaphore;

public class BoundedBuffer {

    private Semaphore lock = new Semaphore(1);
    private Semaphore fullBuffer = new Semaphore(0);
    private Semaphore emptyBuffer = new Semaphore(10);

    void deposit() throws InterruptedException {
        emptyBuffer.acquire();


    }

}
