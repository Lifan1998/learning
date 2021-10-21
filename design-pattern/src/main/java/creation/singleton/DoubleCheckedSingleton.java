package creation.singleton;

/**
 * @author fan.li
 * @date 2021-10-15
 * @description
 *
 * 双重检查
 *
 * volatile + 双重检查是绝配啊
 */
public class DoubleCheckedSingleton {

    /**
     * 使用 volatile 来保证可见性
     */
    private volatile static DoubleCheckedSingleton singleton;

    private DoubleCheckedSingleton () {}

    public static DoubleCheckedSingleton getSingleton() {
        // 乐观锁思想
        if (singleton == null) {
            // 锁住整个对象，互斥锁往往用来解决原子性，有序性和可见性可以用volatile实现乐观锁
            synchronized (DoubleCheckedSingleton.class) {
                // 为什么还要检查，因为第一次检查时对象还没有new出来，比如有个线程刚拿到锁，这种可能会放多个线程进来，然后阻塞在锁前面，如果锁里面不检查，后续阻塞线程都会创建锁

                if (singleton == null) {
                    singleton = new DoubleCheckedSingleton();
                }
            }
        }
        return singleton;
    }
}

