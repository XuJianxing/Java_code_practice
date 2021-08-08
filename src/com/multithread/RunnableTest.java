package com.multithread;

import java.util.concurrent.Callable;

/**
 * 一个Runnable类创建了一个对象，开始了三个start()方法
 * run()里加了Thread.sleep()模拟网络延迟
 */
public class RunnableTest {
    public static void main(String[] args) {
        // 一份资源
        BuyTickets bt = new BuyTickets();
        System.out.println(Thread.currentThread().getName()+" method");
        // 多个代理
        new Thread(bt, "a").start();
        new Thread(bt, "b").start();
        new Thread(bt, "c").start();
    }
}
class BuyTickets implements Runnable{
    private int ticketNums = 100;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }
    private void buy(){
        if (ticketNums <= 0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(200);  // 模拟网络延迟
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" ticketNums:" + ticketNums--);
    }

}
