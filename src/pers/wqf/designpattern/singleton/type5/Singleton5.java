package pers.wqf.designpattern.singleton.type5;

/**
 * @author Qifeng Wen
 * @date 2020-06-27 下午6:06
 */
public class Singleton5 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

/**
 * 单例模式
 * 懒汉式（双重检测 线程安全）
 * 提供一个静态共有方法加入双重检查代码，解决线程安全问题以及懒加载问题又保证了效率
 * 推荐使用
 */
class Singleton {
    // 构造器私有化，防止外部new
    private Singleton() {
    }

    // 使用了volatile关键字修饰，主要是避免在多线程环境下由于编译器进行的重排序操作而导致的线程安全问题
    private static volatile Singleton instance;


    // 提供外部获取实例方法
    public static Singleton getInstance() {
        // 使用到时再创建
        if (instance == null) { // 如果不在此判断一次，多个线程会直接去获取锁，假如第一个进来的创建实例了，后面进来的还是需要等待锁，效率低，而在此加上判断，假如创建实例后后面的线程来了会直接返回实例对象而不是接着等待锁的释放，效率较高
            synchronized (Singleton.class) {
                if (instance == null) instance = new Singleton();
            }
        }
        return instance;
    }

}
