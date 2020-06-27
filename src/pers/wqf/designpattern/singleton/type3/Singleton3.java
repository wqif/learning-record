package pers.wqf.designpattern.singleton.type3;

/**
 * @author Qifeng Wen
 * @date 2020-06-27 下午5:20
 */
public class Singleton3 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

/**
 * 单例模式
 * 懒汉式（线程不安全）
 * 实际才开存在风险不可使用
 */
class Singleton {
    // 构造器私有化，防止外部new
    private Singleton() {
    }

    private static Singleton instance;


    // 提供外部获取实例方法
    public static Singleton getInstance() {
        // 使用到时再创建
        if (instance == null) instance = new Singleton();
        return instance;
    }

}
