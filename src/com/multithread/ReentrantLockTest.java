package com.multithread;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 可重入锁
 * 锁可以延续使用 + 计数器
 */
public class ReentrantLockTest {
    // 测试Java中 synchronized 的可重入锁
    public void test(){
        // 第一次获得锁
        synchronized (this){
            while (true){
                // 第二次获得同样的锁
                synchronized (this){
                    System.out.println("ReentrantLock!");
                }
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    // JUC包自带的
    // ReentrantLock reentrantLock = new ReentrantLock();
    // ----- 不可重入锁：
    //UnReentrantLock lock = new UnReentrantLock();
    // ----- 可重入锁：
    MyReentrantLock lock = new MyReentrantLock();
    public void a(){
        lock.lock();
        System.out.println(lock.getHoldCount());  // 看锁的个数
        b();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    public void b(){
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    // -----
    public static void main(String[] args) {
        // new ReentrantLockTest().test();
        ReentrantLockTest test = new ReentrantLockTest();
        test.a();

    }
}

//不可重入锁：锁不可以延续使用
class UnReentrantLock{
    // 是否占用
    private boolean isLocked = false;
    // 使用锁
    public synchronized void lock(){
        //if (isLocked){  // if 效果一样
        while (isLocked){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        isLocked = true;
    }
    // 释放锁
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}

//可重入锁
class MyReentrantLock{
    // 是否占用
    private boolean isLocked = false;
    private Thread lockedBy = null; // 存储使用锁的线程
    private int holdCount = 0;
    // 使用锁
    public synchronized void lock(){
        Thread t = Thread.currentThread();
        while (isLocked && lockedBy != t){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        isLocked = true;
        lockedBy = t;
        holdCount++;
    }
    // 释放锁
    public synchronized void unlock(){
        if (Thread.currentThread() == lockedBy){
            holdCount--;
            if (holdCount == 0){
                isLocked = false;
                notify();
                lockedBy = null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}
