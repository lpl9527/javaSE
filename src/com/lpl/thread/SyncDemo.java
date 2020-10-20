package com.lpl.thread;

/**
 * 同步
 *      一个多线程的程序，类中的属性可被多个线程共享，如果出现多个线程操作同一个公共资源就可能会出现
 *      资源同步问题。
 */
class MyThread8 implements Runnable{

    //可修改的成员变量，多线程时可能会出现资源共享的同步问题
    private int ticket = 5;     //有5张票
    @Override
    public void run() {
        //使用循环模拟买票
        for (int i=0; i<50; i++){
            this.sale();
        }
    }
    /**
     * 同步锁synchronized锁住代码块或方法，一个时间只能有一个线程访问，解决线程安全问题
     * 卖票方法
     */
    public synchronized void sale(){
        if (ticket>0){      //如果有票
            try{
                /**
                 * 让当前线程休眠0.5秒，模拟卖票的过程，在此过程中其它线程可能也在卖票，尽
                 * 管可能没有了余票
                 */
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出票，ticket号码 = " + ticket--);
        }
    }
}
public class SyncDemo {
    public static void main(String[] args) {
        MyThread8 myThread = new MyThread8();
        /**
         * 定义多个线程（模拟多个卖票人员），如果只有一个线程操作，则不会出现公共资源争抢导致数据不同步
         * 问题，这里创建多个线程卖票，出现票销售数量大于票数情况。
         *
         * 为何要创建多个线程卖票？
         *      当然是提高并发量，提高卖票效率喽，一个人哪有多个人卖的快
         */
        Thread sale1 = new Thread(myThread, "销售员1");
        Thread sale2 = new Thread(myThread, "销售员2");
        Thread sale3 = new Thread(myThread, "销售员3");

        //开始卖票
        sale1.start();
        sale2.start();
        sale3.start();
    }
}
