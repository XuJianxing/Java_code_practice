package com.multithread;

/**
 * 模拟线程不安全的三个场景：
 * 1. 数据有负数、有相同 （买票 见RunnableTest.java）
 * 2. 存取钱
 * 3. 操作容器
 */
public class ThreadUnsafeSamples {
    public static void main(String[] args) {
        // 2. 存取钱
        Account account = new Account(100, "礼金");
        Draw you = new Draw(account, 80, "you");
        you.start();
        Draw wife = new Draw(account, 90, "her");
        wife.start();
        // 3. 操作容器
        // 容器里加入线程，有的线程被覆盖了，没有全部加入

    }
}
// 2. 存取钱
// 模拟账户
class Account {
    private int money;
    private String name;
    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
// 模拟取钱
class Draw extends Thread{
    private Account account;
    private int drawMoney;  //取得钱数
    private int packetTotal;  // 口袋总数
    public Draw(Account account, int drawMoney, String name){
        this.account = account;
        this.drawMoney = drawMoney;
        this.account.setName(name);
    }
    @Override
    public void run(){
        if (account.getMoney() - drawMoney < 0) return;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.setMoney(account.getMoney() - drawMoney);
        packetTotal += drawMoney;
        System.out.println(this.getName()+"--> 账户余额为"+account.getMoney());
        System.out.println(this.getName()+"--> 口袋的钱为"+packetTotal);
    }
}
