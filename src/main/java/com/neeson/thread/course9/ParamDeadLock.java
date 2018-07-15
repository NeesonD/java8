package com.neeson.thread.course9;

import com.neeson.basic.domain.Account;

/**
 * 参数顺序决定死锁
 * Create by neeson on 2017/9/10
 */
public class ParamDeadLock {

    public void transferMoney(Account fromAccount,Account toAccount){
        synchronized (fromAccount){
            synchronized (toAccount){
              //TODO
            }
        }
    }

}
