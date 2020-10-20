package com.lpl.thread;

/**
 * 线程的强制运行
 */
class MyThread2 implements Runnable{

    /**
     * 可以使用join()方法让一个线程强制运行，线程强制运行期间其他线程无法运行，必须等待该线程运行
     * 完成之后才能运行
     */
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
        }
    }

}
public class ThreadJoinDemo{
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        //创建线程
        Thread thread = new Thread(myThread2, "线程A");
        //启动线程
        thread.start();
        for (int i=0; i<30; i++){
            if (i>10){
                try{
                    //强制线程运行
                    thread.join();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("Main线程运行 : " + i);
        }
    }
}
