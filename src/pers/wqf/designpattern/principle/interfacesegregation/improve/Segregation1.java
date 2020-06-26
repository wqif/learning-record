package pers.wqf.designpattern.principle.interfacesegregation.improve;

/**
 * @author Qifeng Wen
 * @date 2020-06-24 下午9:46
 */


/**
 * 接口隔离原则
 */
public class Segregation1 {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }
}


interface Interface1 {
    void operation1();

}

interface Interface2 {
    void operation2();
    void operation3();

}

interface Interface3{
    void operation4();
    void operation5();
}

class B implements Interface1,Interface2 {

    @Override
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }

}


class D implements Interface1,Interface3 {

    @Override
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }

    @Override
    public void operation4() {
        System.out.println("B 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}

class A{ //通过接口Interface1,Interface2依赖B类但是只用到 1 2 3方法

    public void depend1(Interface1 interface1){
        interface1.operation1();
    }

    public void depend2(Interface2 interface2){
        interface2.operation2();
    }

    public void depend3(Interface2 interface2){
        interface2.operation3();
    }
}

class C{//通过接口Interface1,Interface3依赖D类但是只用到 1 4 5方法

    public void depend1(Interface1 interface1){
        interface1.operation1();
    }

    public void depend4(Interface3 interface3){
        interface3.operation4();
    }

    public void depend5(Interface3 interface3){
        interface3.operation5();
    }
}