package com.multithread;

/**
 * synchronized 方法
 */
public class SynchronizedTest1 {
    public static void main(String[] args) {
        // 一份资源
        SynchronizedBuyTickets bt = new SynchronizedBuyTickets();
        System.out.println(Thread.currentThread().getName()+" method");
        // 多个代理
        new Thread(bt, "a").start();
        new Thread(bt, "b").start();
        new Thread(bt, "c").start();
    }
}

class SynchronizedBuyTickets implements Runnable{
    private int ticketNums = 100;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            buy1();
        }
    }
    // 这里synchronized锁的是bt对象，而不是方法。因为方法内的成员变量都是对象里的变量
    // 线程安全 同步
    private synchronized void buy1(){
        notToDuplicated();
    }
    // 线程安全 同步块  范围太大，性能低
    private void buy2(){
        synchronized(this) {
            notToDuplicated();
        }
    }
    // 线程不安全 ticketNums对象在变，引用在变，所以锁不住。前面的this地址不变，所以锁得住
    private void buy3(){
        synchronized((Integer) ticketNums) {
            notToDuplicated();
        }
    }
    // 锁的范围太小，锁不住
    private void buy4(){
        synchronized((Integer) ticketNums) {
            synchronized (this){
                if (ticketNums <= 0){
                    flag = false;
                    return;
                }
            }
            try {
                Thread.sleep(200);  // 模拟网络延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ticketNums:" + ticketNums--);
        }
    }
    // 线程安全：尽可能锁定合理的范围（不是指代码，是数据的完整性）
    // double checking
    private void buy5(){
        if (ticketNums <= 0){  // 考虑的是没有票的情况 直接返回，不用进入锁
            flag = false;
            return;
        }
        synchronized(this) {
            // 考虑有票的情况。
            // （每一张）都在争用，则要加锁，只让一个线程进入
            // 最后一张票时，双重检查，如果没票就退出
            notToDuplicated();
        }
    }
    // 重复多次的buy方法，写在外面了
    private void notToDuplicated(){
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(200);  // 模拟网络延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ticketNums:" + ticketNums--);
    }

}
