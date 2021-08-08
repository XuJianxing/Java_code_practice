package com.multithread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * java.util.Timer 类是定时触发一次线程。
 * java,util.TimerTask 是一个抽象类，实现了Runnable接口。
 *
 * 在这种实现方式中，通过继承TimerTask使该类获得多线程的能力，将需要多线程执行的代码书写在run方法内部，然后通过Timer类启动线程的执行。
 *
 * 任务调度框架：QUARTZ
 * Scheduler: 调度器，控制所有的调度
 * Trigger: 触发条件，采用DSL模式：
 *   Domain-specific language 针对一个特定领域
 *   方法链、嵌套函数、lambda、functional sequence
 * JobDetail: 需要处理的Job
 * Job: 执行逻辑
 */
public class TimerAndTaskTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 执行安排
        timer.schedule(new MyTask(), 1000);  //1s后 执行任务一次
        timer.schedule(new MyTask(), 1000, 200);  //1s后 执行任务多次，每隔200ms
        GregorianCalendar c = new GregorianCalendar(2020, Calendar.JANUARY,1,12,0,0);
        timer.schedule(new MyTask(), c.getTime());  // (TimerTask, Date)

    }
}

//任务类
class MyTask extends TimerTask{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyTask_"+i);
        }
        System.out.println("end!");
    }
}