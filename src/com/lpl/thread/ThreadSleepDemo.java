package com.lpl.thread;

/**
 * 线程的休眠
 */
class MyThread3 implements Runnable{
    /**
     * 线程要执行的操作
     */
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            try{
                //线程休眠0.5秒
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
        }
    }
}

public class ThreadSleepDemo{
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        //创建状态
        Thread thread = new Thread(myThread3,"线程A");
        //就绪状态
        thread.start();
    }
}