package pers.wqf.designpattern.singleton.type6;

/**
 * @author Qifeng Wen
 * @date 2020-06-27 下午6:20
 */
public class Singleton6 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

/**
 * 单例模式
 * 静态内部类
 * 使用延时加载，使用时才进行对象初始化，也不会造成造成资源浪费；
 * 另一方面，类的静态属性只会在第一次加载的时候初始化，并且
 * JVM在类的加载时已经做了同步处理，不会出现线程安全问题
 * 强烈推荐
 */
class Singleton {
    // 构造器私有化，防止外部new
    private Singleton() {
    }

    // 写一个静态内部类，该类中有一个静态数学Singleton
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 提供外部获取实例方法
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

}
