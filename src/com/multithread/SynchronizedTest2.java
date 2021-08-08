package com.multithread;

/**
 * synchronized块
 * 使用 synchronized块 的功能，对代码块加锁
 */
public class SynchronizedTest2 {
    public static void main(String[] args) {
        Account account = new Account(100, "礼金");
        SynchronizedDraw you = new SynchronizedDraw(account, 80, "you");
        you.start();
        SynchronizedDraw wife = new SynchronizedDraw(account, 90, "her");
        wife.start();
    }
}
// 模拟账户 Account类 见ThreadUnsafeSample.java

// 模拟取钱
class SynchronizedDraw extends Thread{
    private Account account;
    private int drawMoney;  //取得钱数
    private int expenseTotal;  // 口袋总数
    public SynchronizedDraw(Account account, int drawMoney, String name){
        this.account = account;
        this.drawMoney = drawMoney;
        this.account.setName(name);
    }
    @Override
    public void run(){
        draw();
    }
    private void draw(){
        // 提高性能
        if (account.getMoney() <= 0) return;
        /**
         * 要锁谁，就对谁加 synchronized
         * synchronize account对象的时候，编译器报警告，这是因为加锁的对象不是final的
         * 如果对象的引用不是final修饰的，则在改变对象内容的时候，其他线程也可以访问对象
         * final 修饰的 对象的引用 指的是： 引用不能修改，而对象内容仍可以修改
         */
        synchronized (account){
            if (account.getMoney() - drawMoney < 0) {
                System.out.println(this.getName() + "取款，余额不足！");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.setMoney(account.getMoney() - drawMoney);
            expenseTotal += drawMoney;
        }
        System.out.println(this.getName()+"--> 账户余额:"+account.getMoney());
        System.out.println(this.getName()+"--> 取的钱:"+expenseTotal);
    }
}
