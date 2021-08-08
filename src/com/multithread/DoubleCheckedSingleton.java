package com.multithread;

/**
 * 单例模式：套路，在多线程环境下，对外存在一个对象
 * 1. 构造器私有化 --> 避免外部调用构造器new对象
 * 2. 提供私有的静态属性 --> 存储对象的地址
 * 3. 提供公共的静态方法 --> 获取属性
 */
public class DoubleCheckedSingleton {
    // 2. 提供私有的静态属性
    // 直接new对象了，是饿汉式；没有new是懒汉式
    // 没有volatile，其他线程可能访问一个没有初始化的对象
    private static volatile DoubleCheckedSingleton instance;

    // 1. 构造器私有化
    private DoubleCheckedSingleton(){}
    // 3. 提供公共的静态方法 --> 获取属性
    public static DoubleCheckedSingleton getInstance(){
        // double-checking
        if (instance != null) return instance;
        synchronized (DoubleCheckedSingleton.class){  // 锁定类对象
            if (instance == null)
                instance = new DoubleCheckedSingleton();
            // 实例化对象的过程：1. 开辟空间 2. 初始化对象信息 3. 返回对象的地址给引用
            // 为了避免指令重排 导致 先给另一个线程返回对象地址的引用（这将会导致返回一个null对象）
            // 要对对象加volatile
        }
        return instance;
    }
}
