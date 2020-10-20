package com.lpl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABA {

    //-------------------------------------------ABA问题----------------------------------------
    /*private static AtomicInteger index = new AtomicInteger(10);

    public static void main(String[] args) {
        //张三线程去修改index的值
        new Thread(() -> {
            //通过CAS自旋算法锁修改index的值
            index.compareAndSet(10, 11);
            index.compareAndSet(11, 10);
            System.out.println(Thread.currentThread().getName() + "  10 -> 11 -> 10");
        }, "张三").start();

        //李四线程去读取内存值并设置新值
        new Thread(() -> {
            try{
                //线程休眠2秒
                TimeUnit.SECONDS.sleep(2);
                //判断是否修改成功
                boolean isSuccess = index.compareAndSet(10, 12);
                System.out.println(Thread.currentThread().getName() + "  index是否是预期的值：" + isSuccess + "，设置的新值是：" + index.get());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "李四").start();
    }*/

    //-------------------------------------------ABA问题解决方案1----------------------------------------

    /*private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(10, 1);

    public static void main(String[] args) {
        //张三线程去修改参考对象的值
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  拿到的当前时间戳版本号为：" + atomicStampedReference.getStamp());

            //休眠1秒，为了让李四线程也拿到同样的初始版本号
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            //通过CAS自旋算法锁修改index的值
            atomicStampedReference.compareAndSet(10, 11, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            atomicStampedReference.compareAndSet(11, 10, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "  10 -> 11 -> 10");
        }, "张三").start();

        //李四线程去读取内存值并设置新值
        new Thread(() -> {
            try{
                int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName() + "  拿到的当前时间戳版本号为：" + stamp);
                //线程休眠2秒，为了让张三线程完成ABA操作
                TimeUnit.SECONDS.sleep(2);
                //判断是否修改成功
                boolean isSuccess = atomicStampedReference.compareAndSet(10, 12, stamp, atomicStampedReference.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "  最新版本号：" + atomicStampedReference.getStamp() + "，是否修改成功：" + isSuccess + "，当前值是：" + atomicStampedReference.getReference());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "李四").start();
    }*/

    //-------------------------------------------ABA问题解决方案2----------------------------------------
    private static AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference<Integer>(10, false);

    public static void main(String[] args) {
        //张三线程去修改参考对象的值
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  当前参考对象是否被修改：" + atomicMarkableReference.isMarked());

            //休眠1秒，为了让李四线程也拿到是否被修改的标识
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            //通过CAS自旋算法锁修改index的值
            atomicMarkableReference.compareAndSet(10, 11, atomicMarkableReference.isMarked(), true);
            atomicMarkableReference.compareAndSet(11, 10, atomicMarkableReference.isMarked(), true);
            System.out.println(Thread.currentThread().getName() + "  10 -> 11 -> 10");
        }, "张三").start();

        //李四线程去读取内存值并设置新值
        new Thread(() -> {
            try{
                boolean isMarked = atomicMarkableReference.isMarked();
                System.out.println(Thread.currentThread().getName() + "  当前参考对象是否被修改：" + isMarked);
                //线程休眠2秒，为了让张三线程完成ABA操作
                TimeUnit.SECONDS.sleep(2);
                //判断是否修改成功
                boolean isSuccess = atomicMarkableReference.compareAndSet(10, 12, isMarked, true);
                System.out.println(Thread.currentThread().getName() + "  当前修改状态为：" + atomicMarkableReference.isMarked() + "，是否修改成功：" + isSuccess + "，当前值是：" + atomicMarkableReference.getReference());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "李四").start();
    }
}
