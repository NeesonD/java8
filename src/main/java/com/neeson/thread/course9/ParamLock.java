package com.neeson.thread.course9;

import com.neeson.basic.domain.Account;
import com.neeson.basic.domain.DollarAmount;

/**
 * Create by neeson on 2017/9/10
 * 通过锁顺序来避免死锁
 */
public class ParamLock {

    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAcct,final Account toAcct,final DollarAmount amount){
        class Helper{
            public void transfer(){
                //TODO
            }
        }
        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);

        if (fromHash > toHash){
            synchronized (fromAcct){
                synchronized (toAcct){
                    new Helper().transfer();
                }
            }
        }else if (fromHash < toHash){
            synchronized (toAcct){
                synchronized (fromAcct){
                    new Helper().transfer();
                }
            }
        }else {
            synchronized (tieLock){
                synchronized (fromAcct){
                    synchronized (toAcct){
                        new Helper().transfer();
                    }
                }
            }
        }
    }

}
