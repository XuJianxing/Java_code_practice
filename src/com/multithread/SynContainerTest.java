package com.multithread;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 用并发容器
 */
public class SynContainerTest {
    public static void main(String[] args) throws InterruptedException {
        // 并发容器  写时拷贝
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        // 普通容器
        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> list.add(Thread.currentThread().getName())).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> list2.add(Thread.currentThread().getName())).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
        System.out.println(list2.size());  // 没加同步的容器，会出错
        for (String s:list
             ) {
            System.out.println(s);
        }
        System.out.println("---");
        for (String s:list2
             ) {
            System.out.println(s);
        }
    }
}
