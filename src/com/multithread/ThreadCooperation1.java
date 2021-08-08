package com.multithread;

/**
 * 线程并发协作
 * 生产者消费者
 * 管程法 （用容器，两个角色只与容器交互）
 */
public class ThreadCooperation1 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}
// 缓冲区（它自己提供了生产和消费的方法）
class SynContainer{
    private Stuff[] buffer = new Stuff[10];
    private int count = 0;

    // 存，要加入同步方法（只加同步语句也不够，因为要考虑缓冲区满或空）
    public synchronized void push(Stuff p){
        // 不能生产
        if (count == buffer.length)
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        // 容器中存在空间，则可以生产
        buffer[count] = p;
        count++;
        // 生产了以后，就可以通知其他线程消费了
        notifyAll();
    }

    // 消费的方法
    public synchronized Stuff pop() {
        // 容器中是否存在数据？没有数据要等待
        if (count == 0) {
            try {
                wait();  // wait()方法让线程阻塞了。生产者通知消费者解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Stuff temp = buffer[count];
        notifyAll();  // 消费了以后，要提醒其他线程解除阻塞
        return temp;
    }
    public int getCount(){
        return count;
    }
}
// 生产者
class Producer extends Thread{
    private SynContainer container;
    public Producer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        // 生产，加到缓冲区
        for (int i = 0; i < 100; i++) {
            System.out.printf("生产第%d个馒头\n", i);
            container.push(new Stuff(i));
        }
    }
}
// 消费者
class Consumer extends Thread{
    private SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }
    @Override
    public void run() {
        // 消费者行为
        for (int i = 0; i < 100; i++) {
            // 消费一个物品
            Stuff s = container.pop();
            System.out.printf("消费第%d个馒头\n", s.getId());
        }
    }
}

// 产品
class Stuff{
    private int id;
    public Stuff(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
