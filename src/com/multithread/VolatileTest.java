package com.multithread;

/**
 * volatile用于保证数据的同步，可见性
 * Java线程《-》工作内存《-》(save和load操作)《-》主内存
 */
public class VolatileTest {
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) continue;  // 不加volatile，这个线程一直执行下去，后面的num=1没有修改
        }).start();

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        num = 1;
    }
}
