package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fan.li
 * @date 2021-10-20
 * @description
 *
 * 一个极其简单的死锁demo
 * 过程：某个任务需要对 AB资源 顺序加锁，但是 有另一个任务是对 BA资源 顺序加锁，这样并发情况下就会出问题
 * 拷问：既然是顺序加锁，为什么不能把A锁释放了再加B锁呢？这是业务场景决定的，如果对资源B的操作依赖A的状态，那么两个都要加锁
 *      可以类比事务，原子性：中间过程对外不可见，如果释放锁了，不仅对外可见，还可以修改，那么可以对A加读锁吗，这样就不会修改了，看业务
 *
 * 这种业务场景现实中常见的就是互相转账操作，或者代码不规范，没有提供统一入口，有多个加锁方法
 */

public class SiSuoDemo {

    public static void main(String[] args) {
        // 拿到资源A
        Object a = new Object();

        // 拿到资源b
        Object b = new Object();

        SiSuoDemo siSuoDemo = new SiSuoDemo();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                siSuoDemo.transfer(a, b);
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                siSuoDemo.transfer(b, a);
            }
        };
        new Thread(task1).start();
        new Thread(task2).start();
    }

    /**
     * 并发情况下 入参 AB 调换一下就死锁了
     * @param a
     * @param b
     *
     * 谈谈这种问题的解决方法
     * 1. 将方法加锁：这样加锁对象就改了，没有对共享资源 ab 加锁，需要统一入口
     * 2. ab一起加锁：synchronized 做不到
     *
     * 如果用方法1加锁了就可以了吗，不可以，因为分布式下该资源对象存在多个，所以需要分布式锁
     */
    public void transfer(Object a, Object b) {
        System.out.println(Thread.currentThread() + "正在获取资源: " + a.hashCode());
        synchronized (a) {
            System.out.println(Thread.currentThread() + "已拿到资源: " + a.hashCode());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "1s过去了，尝试获取资源：" + b.hashCode());
            synchronized (b) {
                // do something
                System.out.println(Thread.currentThread() + "已拿到资源：" + b.hashCode());
            }
        }
    }
}

