package pers.wqf.designpattern.singleton.type1;

/**
 * @author Qifeng Wen
 * @date 2020-06-27 下午5:06
 */
public class Singleton1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

/**
 * 单例模式
 * 饿汉式（静态常量）
 * 如果不使用到该类的使用会造成内存浪费
 * 如果确定一定会使用到该类的实例，推荐使用
 */
class Singleton {
    // 构造器私有化，防止外部new
    private Singleton() {
    }

    // 类内部创建对象实例
    private static final Singleton instance = new Singleton();

    // 提供外部获取实例方法
    public static Singleton getInstance() {
        return instance;
    }

}
