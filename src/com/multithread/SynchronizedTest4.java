package com.multithread;

/**
 * 用 synchronized方法 实现同步 买火车票
 */
public class SynchronizedTest4 {
    public static void main(String[] args) {
        Web12306 web12306 = new Web12306(3, "12306");
        new Passenger(web12306, 2, "p1").start();
        new Passenger(web12306, 1, "p2").start();
    }
}

/**
 * Web12306类提供了run()方法和同步的bookTickets()方法
 */
class Web12306 implements Runnable{
    private int available;  // 可用位置
    private String name;  // 名称
    public Web12306(int available, String name){
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger p = (Passenger) Thread.currentThread();
        boolean flag = this.bookTickets(p.getSeats());
        if (flag) {
            System.out.println("出票成功：" + Thread.currentThread().getName() +
                    ", 位置个数：" + p.getSeats());
        } else {
            System.out.println("出票失败：" + Thread.currentThread().getName() +
                    "，位置不够:" + p.getSeats());
        }
    }

    // 同步方法：购票
    public synchronized boolean bookTickets(int seats){
        System.out.println(Thread.currentThread().getName()+"可用位置为：" + available);
        if (seats > available) return false;
        available -= seats;
        return true;
    }
}

class Passenger extends Thread{
    private int seats;
    public Passenger(Runnable target, int seats, String name){
        super(target, name);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
