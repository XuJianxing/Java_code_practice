package com.multithread;

/**
 * 测试死锁
 * 过多的同步可能造成互相不释放资源
 * 从而互相等待，一般发生在同步中持有多个对象的锁
 */
public class DeadLockTest {
    public static void main(String[] args) {
        UnlockedMakeup m1 = new UnlockedMakeup(0, "Taylor");
        UnlockedMakeup m2 = new UnlockedMakeup(1, "Swift");
        m1.start();
        m2.start();
    }
}

class A{}
class B{}

class LockedMakeup extends Thread{
    private static A a = new A();
    private static B b = new B();  // 静态的对象，说明只有一个
    private int choice;
    private String name;
    public LockedMakeup(int choice, String name){
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private void makeup() throws InterruptedException {
        if (choice == 0){
            synchronized (a){  // 要得到A的对象的锁
                System.out.println(name + "拿到A了！");
                Thread.sleep(1000);
                synchronized (b){  //再得到b对象的锁
                    System.out.println(name + "拿到B了");
                }
            }
        }else {
            synchronized (b){  // 先拿到B对象的锁
                System.out.println(name + "拿到B.b了！");
                Thread.sleep(1000);
                synchronized (a) {  // 然后再拿A
                    System.out.println(name + "拿到A.a了！");
                }
            }
        }
    }
}

class UnlockedMakeup extends Thread{
    private static A a = new A();
    private static B b = new B();  // 静态的对象，说明只有一个
    private int choice;
    private String name;
    public UnlockedMakeup(int choice, String name){
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private void makeup() throws InterruptedException {
        if (choice == 0){
            synchronized (a){  // 要得到A的对象的锁
                System.out.println(name + "拿到A了！");
                Thread.sleep(1000);

            }
            synchronized (b){  //再得到b对象的锁
                System.out.println(name + "拿到B了");
            }
        }else {
            synchronized (b){  // 先拿到B对象的锁
                System.out.println(name + "拿到B.b了！");
                Thread.sleep(1000);
            }
            synchronized (a) {  // 然后再拿A
                System.out.println(name + "拿到A.a了！");
            }
        }
    }
}