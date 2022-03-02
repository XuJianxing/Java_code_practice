package foroffer.offer;

/**
 * 几种单例模式的写法
 */

public class Singleton {
    /**
     * 懒汉式
     */
    private static Singleton instance;  // 静态私有对象，不马上初始化对象
    private Singleton(){}  // 私有构造方法
    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    public static synchronized Singleton getInstance2(){  // 加了线程安全
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}

class Singleton2 {
    /**
     * 饿汉式，没有线程安全问题
     */
    private static final Singleton2 instance = new Singleton2();
    private Singleton2(){}  // 私有构造方法
    public static Singleton2 getInstance(){
        return instance;
    }
}

class Singleton3 {
    /**
     * 双重校验 double-checked locking
     */
    private static volatile Singleton3 instance;  // 静态私有对象，不马上初始化对象
    private Singleton3(){}  // 私有构造方法
    public static Singleton3 getInstance(){
        if (instance == null) {
            synchronized (Singleton3.class){
                if (instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

class Singleton4 {
    /**
     * 静态内部类，适用于静态域
     */
    private Singleton4(){}  // 私有构造方法
    private static final class InstanceHolder {
        private static final Singleton4 instance = new Singleton4();  // 静态私有对象，不马上初始化对象
    }

    public static Singleton4 getInstance(){
        return InstanceHolder.instance;
    }
}

/**
 * 枚举保证了线程安全，保证了反射安全，保证了序列化
 */
enum Singleton5 {
    INSTANCE;
}
