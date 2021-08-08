package com.multithread;

/**
 * 指令重排
 * 执行代码的顺序可能与编写代码的顺序不一致
 */
public class HappenBefore {
    private static int a = 0;
    private static boolean flag = false;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            try {
                test();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
    private static void test() throws InterruptedException {
        // 线程1 更改数据
        Thread t1 = new Thread(() -> {
            a = 1;
            flag = true;
        });
        // 线程2 读数据
        Thread t2 = new Thread( () -> {
            if (flag)
                a *= 1;
            // 指令重排
            if (a == 0)
                System.out.println("a="+a);
        });
        t1.start();
        t2.start();
    }
}
