package pers.wqf.designpattern.singleton.type4;

/**
 * @author Qifeng Wen
 * @date 2020-06-27 下午5:31
 */
public class Singleton4 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

/**
 * 单例模式
 * 懒汉式（线程安全）
 * 加入了同步锁，如果多个线程同时获取实例会存在等待同步锁释放，效率低
 * 不推荐使用
 */
class Singleton {
    // 构造器私有化，防止外部new
    private Singleton() {
    }

    private static Singleton instance;


    // 提供外部获取实例方法
    public static synchronized Singleton getInstance() {
        // 使用到时再创建
        if (instance == null) instance = new Singleton();
        return instance;
    }

}
