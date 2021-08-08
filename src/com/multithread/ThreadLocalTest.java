package com.multithread;

/**
 * ThreadLocal: 每个线程自身的存储本地、局部变量区域
 * 可以 同一个线程内 的 多个线程间 共享数据
 * 建议ThreadLocal定义为 private static
 * 提供get set initialValue方法
 *
 * 常用地方：为每个线程绑定一个数据库连接、HTTP请求、用户身份信息等。
 */
public class ThreadLocalTest {
    // private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    // 更改初始化值
    private static ThreadLocal<Integer> threadLocalA = new ThreadLocal<>(){
        protected Integer initialValue(){
            return 100;
        }
    };
    private static ThreadLocal<Integer> threadLocalB = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+": "+threadLocalA.get());
        // System.out.println(Thread.currentThread().getName()+": "+threadLocal2.get());
        threadLocalA.set(300);
        System.out.println(Thread.currentThread().getName()+": "+threadLocalA.get());

        // 各个线程的 threadlocal 不影响
        new Thread(new ThreadLocalTestA()).start();
        new Thread(new ThreadLocalTestA()).start();
        new Thread(new ThreadLocalTestA()).start();

        new Thread(new ThreadLocalTestB()).start();
        new Thread(new ThreadLocalTestB()).start();
    }

    static class ThreadLocalTestA implements Runnable{
        public ThreadLocalTestA(){
            // 谁调用 就属于谁的
            threadLocalA.set(-1);
            System.out.println(Thread.currentThread().getName()+": "+threadLocalA.get());
        }
        @Override
        public void run() {
            threadLocalA.set((int)(Math.random() * 100));  // 0~99的随机整数
            System.out.println(Thread.currentThread().getName()+": "+threadLocalA.get());
        }
    }

    static class ThreadLocalTestB implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"得到了: "+threadLocalB.get());
            threadLocalB.set(threadLocalB.get() - 1);
            System.out.println(Thread.currentThread().getName()+"🗡减1之后: "+threadLocalB.get());
        }
    }
}
