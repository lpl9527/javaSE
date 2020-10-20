package com.lpl.thread;

/**
 * 线程的优先级
 */
class MyThread6 implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<5; i++){
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
        }
    }
}

public class ThreadPrioityDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread6(), "线程A");
        Thread thread2 = new Thread(new MyThread6(), "线程B");
        Thread thread3 = new Thread(new MyThread6(), "线程C");
        //设置线程优先级，从1到10，数值越小优先级越小
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        /**
         * 注意：并非那个线程的优先级越高线程就越先执行，具体由CPU调度决定
         */
        //启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
