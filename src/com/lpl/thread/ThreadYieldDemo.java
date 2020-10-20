package com.lpl.thread;

/**
 * 线程的礼让
 *      将一个线程的操作（run()方法中执行的逻辑）暂时让给其他线程执行
 */
class MyThread7 implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<5; i++){
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);

            if (i == 2){
                System.out.print("线程礼让：");
                Thread.currentThread().yield();     //线程礼让
            }
        }
    }
}
public class ThreadYieldDemo {

    public static void main(String[] args) {
        MyThread7 myThread = new MyThread7();
        Thread thread1 = new Thread(myThread, "线程A");
        Thread thread2 = new Thread(myThread, "线程B");
        thread1.start();
        thread2.start();
    }

}
