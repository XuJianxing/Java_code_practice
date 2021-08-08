package com.multithread;

import java.util.List;

/**
 * 协作模型：生产者消费者实现二：信号灯法
 * 借助标志位
 */
public class ThreadCooperation2 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Speaker(tv).start();
        new Listener(tv).start();
    }
}
// 同一个资源 电视
class Tv{
    private String words;
    // 1信号量 true: 演员表演 观众等待 false: 观众观看 演员等待
    private boolean flag = true;

    public synchronized void speak(String words){
        if (!flag)
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        System.out.println("Said: " + words);
        this.words = words;
        // 表演了以后，唤醒，并切换
        flag = !flag;
        notifyAll();
    }

    public synchronized String listen(){
        if (flag)
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        System.out.println("Hear: " + words);
        // 唤醒，并切换
        flag = !flag;
        notifyAll();
        return words;
    }
}
// 生产者 （生产者和消费者，在类里都有一个成员对象，构造函数里传进这个对象。这样表示两个角色都操作同一个对象）
// 这样在同一个对象里实现synchronized方法，就可以实现同步
class Speaker extends Thread{
    private Tv tv;
    public Speaker(Tv tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0)
                tv.speak("yes");
            else tv.speak("I do!");
        }
    }
}
// 消费者 观众
class Listener extends Thread{
    private Tv tv;
    public Listener(Tv tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.listen();
        }
    }
}