package behavior.visitor;

/**
 * @author fan.li
 * @web https://www.lifan.org.cn
 * @date 2021-04-01
 * @description
 */

public class DemoMain {
    public static void main(String[] args) {
        SingleDispatchClass0 demo = new SingleDispatchClass0();
        ParentClass p = new ChildClass();
        //执行哪个对象的方法，由对象的实际类型决定
        demo.polymorphismFunction(p);
        //执行对象的哪个方法，由参数对象的声明类型决定
        demo.overloadFunction(p);
    }
}


class ParentClass {
    public void f() {
        System.out.println("I am ParentClass's f().");
    }
}

class ChildClass extends ParentClass {
    @Override
    public void f() { System.out.println("I am ChildClass's f().");
    }
}

/**
 * 单分派
 */
class SingleDispatchClass {
    public void polymorphismFunction(ParentClass p) {
        p.f();
    }

    public void overloadFunction(ParentClass p) {
        System.out.println("I am overloadFunction(ParentClass p).");
    }
    public void overloadFunction(ChildClass c) {
        System.out.println("I am overloadFunction(ChildClass c).");
    }
}

class SingleDispatchClass0 {
    public void polymorphismFunction(ParentClass p) {
        p.f();
    }

    public void overloadFunction(ParentClass p) {
        System.out.println("I am overloadFunction(ParentClass p).");
        p.f();
    }
    public void overloadFunction(ChildClass c) {
        System.out.println("I am overloadFunction(ChildClass p).");
        c.f();
    }
}


