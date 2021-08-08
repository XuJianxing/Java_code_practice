package com.multithread;


public class YieldTest {
    public static void main(String[] args) {
        StateThread st = new StateThread();
        new Thread(st, "st1").start();
        new Thread(st, "st2").start();
    }
}

class StateThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+": end");
    }
}
