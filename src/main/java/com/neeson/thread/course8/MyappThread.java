package com.neeson.thread.course8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by daile on 2017/9/8.
 */
public class MyappThread extends Thread {

    public static final String DEFAULT_NAME = "MyAPPThread";
    private static volatile boolean debugLifecycle = false;
    private static final AtomicInteger created = new AtomicInteger();

    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public MyappThread(Runnable runnable,String name){
        super(runnable,name + "-"+created.incrementAndGet());
        setUncaughtExceptionHandler((t,e) -> LOGGER.log(Level.SEVERE,"UNCAUGHT in thread"+t.getName(),e));
    }

    public void run(){
        boolean debug = debugLifecycle;
        if (debug) LOGGER.log(Level.FINE,"Created"+getName());
        try {
            alive.incrementAndGet();
            super.run();
        }finally {
            alive.decrementAndGet();
            if (debug) LOGGER.log(Level.FINE,"Exiting"+getName());
        }
    }

    public static int getThreadsCreated(){
        return created.get();
    }

    public static int getThreadsAlive(){
        return alive.get();
    }

    public static boolean getDebug(){
        return debugLifecycle;
    }

    public static void setDebug(boolean b){
        debugLifecycle = b;
    }
}
