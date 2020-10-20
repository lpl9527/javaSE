package com.lpl.thread;

import java.util.List;

/**
 * 死锁
 *      同步可以保证资源共享操作的正确性，但是过多哦同步也会产生问题。
 *      所谓死锁，就是两个线程都在占用对方所需的资源，请求不到对方资源也不会释放自己占用的资源，就这
 *      样互相等待，又无其他外力影响，导致死锁。
 *      例如：
 *          现在张三想要李四的画，李四想要张三的书，张三对李四说：“把你的画给我，我就给你书”，李四也对
 *      张三说：“把你的书给我，我就给你画”，两个人互相等待对方先行动（释放占用资源），就这样没有结果。
 *      产生死锁的必要条件：
 *          互斥条件：进程要求对所分配的资源进行排它性控制，即在一段时间内某资源仅为一进程所占用。
 *          请求和保持条件：当进程因请求资源而阻塞时，对已获得的资源保持不放。
 *          不剥夺条件：进程已获得的资源在未使用完之前，不能剥夺，只能在使用完时由自己释放。
 *          环路等待条件：在发生死锁时，必然存在一个进程--资源的环形链。
 */
class Zhangsan{
    public void say(){
        System.out.println("张三对李四说：“你给我画，我就把书给你！”");
    }
    public void get(){
        System.out.println("张三得到画了！");
    }
}
class Lisi{
    public void say(){
        System.out.println("李四对张三说：“你给我书，我就把画给你！”");
    }
    public void get(){
        System.out.println("李四得到书了！");
    }
}
public class ThreadDeadLock implements Runnable{

    private static Zhangsan zhangsan = new Zhangsan();
    private static Lisi lisi = new Lisi();
    private boolean flag = false;   //声明标志位，判断哪个先说话

    @Override
    public void run() {
        if (flag){
            //同步锁锁住张三，锁住了张三占用的资源
            synchronized (zhangsan){
                zhangsan.say();
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //同步锁锁住李四
                synchronized (lisi){
                    zhangsan.get();
                }
            }
        }else {
            synchronized (lisi){
                lisi.say();
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (zhangsan){
                    lisi.get();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDeadLock threadDeadLock1 = new ThreadDeadLock();
        ThreadDeadLock threadDeadLock2 = new ThreadDeadLock();
        threadDeadLock1.flag = true;
        threadDeadLock2.flag = false;
        Thread thread1 = new Thread(threadDeadLock1);
        Thread thread2 = new Thread(threadDeadLock2);
        thread1.start();
        thread2.start();
    }

}
