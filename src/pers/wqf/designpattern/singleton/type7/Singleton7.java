package pers.wqf.designpattern.singleton.type7;

/**
 * @author Qifeng Wen
 * @date 2020-06-27 下午8:21
 */
public class Singleton7 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println(instance == instance1);
    }
}

/**
 * 单例模式
 * 枚举方式
 * 能避免多线程同步还能防止反序列化创建新的对象
 * 强烈推荐
 */
enum  Singleton {
    INSTANCE
}
