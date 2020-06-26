package pers.wqf.designpattern.principle.liskovsubstitution;

/**
 * @author Qifeng Wen
 * @date 2020-06-26 下午7:14
 */
public class LiskovSubstitution {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("10-3=" + a.func1(10, 3));

        B b = new B();
        System.out.println("3-2=" + b.func1(3, 2));
    }
}

class A {

    //返回两个数的差
    public int func1(int a, int b) {
        return a - b;
    }
}


class B extends A {
    // 类B可能无意重写了父类方法，造成原有功能出现错误
    public int func1(int a, int b) {
        return a + b;
    }

}
