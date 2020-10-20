package com.lpl.thread;

/**
 * 线程中断
 */
class MyThread4 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "进入run()方法，处于运行状态！");
        try{
            Thread.sleep(10000);    //线程休眠10秒
            System.out.println(Thread.currentThread().getName() + "完成了休眠！");
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName() + "线程被中断了！");
            return;     //返回调用处
        }
        System.out.println(Thread.currentThread().getName() + "的run()方法正常结束！");
    }
}
public class ThreadInterruptDemo{
    public static void main(String[] args) {
        MyThread4 myThread = new MyThread4();
        //创建状态
        Thread thread = new Thread(myThread, "线程A");
        //启动线程，就绪状态
        thread.start();
        try{
            Thread.sleep(2000);     //线程休眠2秒
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName() + "休眠被中止！");
        }
        thread.interrupt();     //中断线程执行
    }
}