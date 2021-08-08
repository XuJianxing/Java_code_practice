package com.multithread;

/**
 * 守护线程：是为用户线程服务的，jvm停止不用等待守护线程执行完毕
 */
public class DaemonTest {
    public static void main(String[] args) {
        Thread god_thread = new God();
        god_thread.setDaemon(true);  // 将用户线程设置为守护线程
        // 先设置再启动！
        god_thread.start();

        Thread people_thread = new People();
        people_thread.start();
    }
}

class People extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("your life year "+i);
        }
        System.out.println("over");
    }
}

class God extends Thread{
    @Override
    public void run() {
        while (true) System.out.println("God's life");
    }
}