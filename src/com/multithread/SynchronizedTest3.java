package com.multithread;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedTest3 {
    public static void main(String[] args) {
        // 创建可用位置
        List<Integer> available = new ArrayList<>();
        available.add(1);available.add(2);available.add(3);available.add(6);available.add(7);
        Cinema cinema = new Cinema(available, "cinema");
        // 创建顾客需要的位置
        List<Integer> seats1 = new ArrayList<>();
        seats1.add(1);seats1.add(2);
        List<Integer> seats2 = new ArrayList<>();
        seats2.add(4);seats2.add(5);seats2.add(6);
        new Thread(new Customer(cinema, seats1)).start();
        new Thread(new Customer(cinema, seats2)).start();
    }
}

class Cinema{
    private List<Integer> available;  // 可用位置
    private String name;  // 名称
    public Cinema(List<Integer> available, String name){
        this.available = available;
        this.name = name;
    }
    // 购票
    public boolean bookTickets(List<Integer> seats){
        System.out.println("可用位置："+available);
        List<Integer> copy = new ArrayList<>(available);   // 把现在可用位置copy一份
        // 相减
        copy.removeAll(seats);
        // 判断订的位置的票是不是符合
        if (available.size() - copy.size() != seats.size())
            return false;
        // 成功
        available = copy;
        return true;
    }
}

class Customer implements Runnable{
    private Cinema cinema;
    private List<Integer> seats;
    public Customer(Cinema cinema, List<Integer> seats){
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功：" + Thread.currentThread().getName() +
                        ", 位置个数：" + seats);
            } else {
                System.out.println("出票失败：" + Thread.currentThread().getName() +
                        "，位置不够" + seats);
            }
        }
    }
}