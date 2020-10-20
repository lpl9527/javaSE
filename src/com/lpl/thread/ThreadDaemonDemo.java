package com.lpl.thread;

/**
 * 后台线程
 *      在Java程序中，只要前台有一个线程在运行，则整个Java进程都不会停止，此时如果设置一个后台线程，这样即使
 *      Java程序结束了，此后台线程依旧会执行。
 */
class MyThread5 implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + "正在运行！");
        }
    }
}
public class ThreadDaemonDemo {

    public static void main(String[] args) {
        MyThread5 myThread = new MyThread5();
        Thread thread  = new Thread(myThread, "线程A");
        //设置线程后台运行
        thread.setDaemon(true);
        //开启线程
        int activeCount = Thread.activeCount();
        System.out.println("活跃的线程数 ： " + activeCount);
        thread.start();
    }
}

