package com.multithread;

/**
 * synchronized只能阻止并发更新同一个共享资源，实现同步；不能用来实现不同线程之间的消息传递（通信）
 *
 * 解决生产者消费者：
 * 1. 用buffer缓冲区，共享内存 -》 管程法
 * 2. 信号灯法
 * 线程通信方式：（只能在同步方法或者同步代码块中使用，否则会抛出异常）
 * 1. final void wait() 表示线程一直等待，直到得到其他线程通知 native方法
 * 2. final void wait(long timeout) 线程等待指定毫秒参数的时间
 * 3. final notify() 唤醒一个处于等待状态的线程
 * 4. final void notifyAll() 唤醒同一个对象上所有调用wait()方法的线程，优先级别高的线程优先运行
 */
public class ThreadCommunication {
    Object o;
}
