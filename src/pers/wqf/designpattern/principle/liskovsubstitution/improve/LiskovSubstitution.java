package pers.wqf.designpattern.principle.liskovsubstitution.improve;

/**
 * @author Qifeng Wen
 * @date 2020-06-26 下午7:14
 */
public class LiskovSubstitution {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("10-3=" + a.func1(10, 3));

        B b = new B();
        // 因为B类不在继承A类  因此调用者不会再认为func1是求减法
        System.out.println("3+2=" + b.func1(3, 2));

        // 仍然可以使用到A的方法
        System.out.println("3-2=" + b.func2(3, 2));
    }
}


// 创建一个更加基础的类
class Base {

}

class A extends Base {

    //返回两个数的差
    public int func1(int a, int b) {
        return a - b;
    }
}


class B extends Base {
    // 如果B仍然想使用A的方法，使用组合关系
    private A a = new A();

    public int func1(int a, int b) {
        return a + b;
    }


    public int func2(int a, int b) {
        return this.a.func1(a, b);
    }

}
