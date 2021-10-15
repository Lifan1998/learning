package creation.singleton;

/**
 * @author fan.li
 * @date 2021-10-15
 * @description
 *
 * 双重检查
 */
public class DoubleCheckedSingleton {

    /**
     * 使用 volatile 来保证可见性
     */
    private volatile static DoubleCheckedSingleton singleton;

    private DoubleCheckedSingleton () {}

    public static DoubleCheckedSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckedSingleton();
                }
            }
        }
        return singleton;
    }
}

