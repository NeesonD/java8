package com.neeson.vm.gc;

/**
 * Created with IntelliJ IDEA.
 * 对象的finalize()只会执行一次
 * @author: neeson
 * Date: 2018/8/5
 * Time: 23:21
 * Description: 虚拟机3-2例子有问题
 */
public class FinalizeEsacapeGC {
    public static FinalizeEsacapeGC SAVE_HOOK=null;

    public void isAlive(){
        System.out.println("yes , I am still alive");
    }

    @Override
    protected void  finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEsacapeGC();

        SAVE_HOOK = null;

        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no , Im dead");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);

        if (SAVE_HOOK!= null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("I am Dead");
        }
    }
}
