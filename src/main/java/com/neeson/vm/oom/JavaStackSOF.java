package com.neeson.vm.oom;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/8/3
 * Time: 0:33
 * Description: -Xss128k
 */
public class JavaStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    private void dontStop(){
        while (true){

        }
    }

    public static void main(String[] args) {
        run1();
        new JavaStackSOF().stackLeakByThread();
    }

    /**
     * 线程过多导致oom
     */
    public void stackLeakByThread(){
        while (true){
            new Thread(() -> dontStop()).start();
        }
    }

    /**
     * 栈深导致的
     */
    private static void run1() {
        JavaStackSOF javaStackSOF = new JavaStackSOF();
        try {
            javaStackSOF.stackLeak();
        } catch (Throwable throwable) {
            System.out.println("stackLength:" + javaStackSOF.stackLength);
            throw throwable;
        }
    }

}
