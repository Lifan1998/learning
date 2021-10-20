package juc;

/**
 * @author fan.li
 * @date 2021-10-20
 * @description
 *
 * 死锁解决方法1
 */
public class SiSuoDemo1 {

    Object a;
    Object b;

    public static void main(String[] args) {
        // 拿到资源A
        Object a = new Object();

        // 拿到资源B
        Object b = new Object();

    }

    public SiSuoDemo1(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    /**
     * 这个可行吗，最关键的是，如何保证资源ab不被其他操作员获取呢，所以这个不行
     * @param a
     * @param b
     */
    public void transfer(Object a, Object b) {
        // 对操作者加锁，相当于将 ab 资源代理，但是问题也很明显，就是get的时候也可能需要对 this 加锁，粒度太大了，可以控制操作者的粒度，让操作者只持有这两个对象，那么这种方案就和两个一起加锁一样了
        synchronized (this) {
            // do something a
            // do something b
        }
    }

    public Object get(String params) {
        synchronized (this) {
            // return a
            return null;
        }
    }
}

