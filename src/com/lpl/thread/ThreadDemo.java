package com.lpl.thread;

/**
 * 线程示例，实现Runnable接口，线程的基础概念
 */
class MyThread implements Runnable{

    /**
     * 进程与线程
     *      进程：
     *          进程是程序的一次动态执行过程，它需要经历从代码加载，到代码执行完毕后的一个过程。多进程
     *      操作系统能同时运行多个进程（程序），由于CPU具有分时机制，所以每个进程都能循环获得自己的CPU时
     *      间片，由于CPU执行非常快，所以看起来好像是所有进程都在同时运行一样。
     *      线程：
     *          线程是比进程更小的执行单位，是在进程的基础上的进一步划分。所谓多线程是指一个进程在执行过
     *          程中可以产生更小的程序单元（线程），这些线程可以同时存在，同时运行，一个进程可能包含多个
     *          正在同时执行的线程。
     */
    private String name;   //线程的名称
    //通过构造方法初始化线程名称
    public MyThread(String name){
        this.name = name;
    }
    /**
     * 线程的操作主体
     */
    @Override
    public void run() {
        //每个线程打印10个数
        for (int i=0; i<10; i++){
            System.out.println(name + "运行，i = " + i);
        }
    }
    /**
     * 线程的5种状态
     *      创建状态（New）：
     *          在程序中创建了一个线程对象后，线程对象便处于新建状态，此时它已经有了相应的内存空间
     *          和其他资源，但还处于不可运行状态。新建一个线程对象一般通过采用Thread类的构造方法实现。
     *      就绪状态（Runnable）：
     *          新建线程对象后，调用该线程的start()方法就会启动该线程。当线程启动后，线程就处于就绪状态。
     *          此时，线程将进入线程队列排队，等待CPU服务，该线程已经具备了运行条件。
     *      运行状态（Running）：
     *          当就绪状态线程被调用（调用run()方法，run()方法定义该线程的操作和功能）并获得处理器资源
     *          时，线程就进入运行状态。
     *      阻塞状态（Blocked）：
     *          阻塞状态是线程因为某种原因，放弃CPU的使用权，暂时停止运行，直到线程进入就绪状态，才有可能
     *          进入运行状态。
     *          阻塞的情况分为三种：
     *              （1）等待阻塞
     *                  运行的线程执行wait()方法，JVM会把该线程放入“等待池”中，进入这个状态后是不能自动
     *                  唤醒的，必须依靠其他线程调用notify()或notifyAll()方法才能被唤醒。
     *              （2）同步阻塞
     *                  运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，JVM会把该线程放入“锁池”中。
     *              （3）其他阻塞
     *                  运行的线程执行sleep()或join()方法，或者发出I/O请求时，JVM会把线程置为阻塞状态。当
     *                  sleep()状态超时、join()等待线程中止或超时、或者I/O处理完毕时，线程重新进入就绪状态。
     *      死亡状态（Dead）：
     *          线程调用stop()方法或者run()方法执行结束后，就会进入死亡状态。死亡状态的线程不再具有继续运
     *          行的能力。
     *      问题：Java程序每次运行至少启动几个线程？
     *          至少启动两个线程，一个是main主线程，另一个是gc线程。
     */
}
public class ThreadDemo {
    public static void main(String[] args) {
        //实例化两个对象
        MyThread myThread1 = new MyThread("线程A");
        MyThread myThread2 = new MyThread("线程B");
        //使用实现了Runnable接口的类实例化Thread对象
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        //设置线程优先级，不设置优先级时哪个线程抢占了CPU资源，哪个线程就运行
        //thread1.setPriority(Thread.MIN_PRIORITY);
        //thread2.setPriority(Thread.MAX_PRIORITY);
        //启动多线程
        thread1.start();
        thread2.start();
        int i = 0;
        System.err.println("main主线程运行中...");
    }
}
