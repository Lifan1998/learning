package enmus;

/**
 * @author fan.li
 * @date 2020-06-28
 * @description
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Color.RED.compareTo(Color.RED));
        System.out.println(BizType.TYPE2.name());
        doSomething(BizType.TYPE1);
    }

    private static void doSomething(BizType bizType) {
        System.out.println(bizType.getClass());
        System.out.println(bizType.getDeclaringClass());
        System.out.println(BizType.values());
//        System.out.println(BizType.valueOf(bizType.getDesc()));
        System.out.println(BizType.valueOf(BizType.TYPE1.name()));
        // do something
        log(bizType.getDesc());
    }

    private static void doSomething0(Integer bizType) {

    }

    private static void doSomething1(String bizType) {

    }

    private static void log(String log) {
        System.out.println(log);
    }

}

