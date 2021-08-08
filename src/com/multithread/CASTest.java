package com.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:
 * 锁分为两类：
 * 悲观锁：synchronized是独占锁即悲观锁，会导致其他所有需要锁的线程挂起，等待
 * 乐观锁：每次不加锁 而是假设没有冲突而区完成某项操作，
 *   如果因为冲突失败就重试，直到成功为止。
 *
 * Compare and Swap 比较并交换
 * 乐观锁的实现：
 * 有三个值，一个当前内存值V，旧的预期值A，将更新的值B。  CAS先获取内存中当前值V，再将内存值V和原值A作比较，要是相等
 * 就修改为要修改的值B并返回true，否则不做并返回false
 *
 * （V应该是内存地址，A是地址里存的值，B是要修改的值）
 * （原子操作，属于硬件级别的操作，利用CPU的CAS指令，同时借助JNI来完成的非阻塞算法）
 */
public class CASTest {
    // 库存  原子操作的Integer
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                // 模拟网络延时
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){}
                Integer left = stock.decrementAndGet();  // -1再返回
                if (left < 0) {
                    System.out.println("over");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " got 1, Left: " + left);
            }).start();

        }
    }
}
