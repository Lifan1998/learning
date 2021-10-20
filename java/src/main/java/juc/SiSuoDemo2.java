package juc;

/**
 * @author fan.li
 * @date 2021-10-20
 * @description
 */

public class SiSuoDemo2 {

    public static void main(String[] args) {
        // 拿到资源A
        Object a = new Object();

        // 拿到资源B
        Object b = new Object();

        SiSuoDemo2 siSuoDemo = new SiSuoDemo2();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                // 先对资源A加锁 ，再对资源B加锁
                siSuoDemo.transfer(a, b);
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                // 先对资源B加锁 ，再对资源A加锁
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
     * 使用按序加锁的方法
     */
    public void transfer(Object a, Object b) {
        // 将资源按一定的规则排序，这里使用 hashcode
        // 这里就两个资源，简单调换下顺序就好了
        if (a.hashCode() > b.hashCode()) {
            Object temp = a;
            a = b;
            b = temp;
        }

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

