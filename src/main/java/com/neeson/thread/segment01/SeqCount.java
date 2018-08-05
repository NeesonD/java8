package com.neeson.thread.segment01;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/3/23
 * Time: 12:17
 * Description:
 */
public class SeqCount {

    private static ThreadLocal<Integer> seqCount = ThreadLocal.withInitial(() -> 0);

    public int nextSeq(){
        seqCount.set(seqCount.get()+1);
        return seqCount.get();
    }

    public static void main(String[] args) {
        SeqCount seqCount = new SeqCount();
        Thread thread1 = new SeqThread(seqCount);
        Thread thread2 =new SeqThread(seqCount);
        Thread thread3 =new SeqThread(seqCount);
        Thread thread4 =new SeqThread(seqCount);
        Thread thread5 =new SeqThread(seqCount);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    static class SeqThread extends Thread{
        private SeqCount seqCount;

        SeqThread(SeqCount seqCount){
            this.seqCount = seqCount;
        }

        @Override
        public void run(){
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"=====>"+seqCount.nextSeq());
            }
        }
    }

}
