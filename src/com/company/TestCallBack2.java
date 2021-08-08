package com.company;

interface Callback {
    void printFinished(String msg);
}
class Printer {
    public void print(Callback callback, String text) {
        System.out.println("正在打印 . . . ");
        try {
            Thread.currentThread();
            Thread.sleep(3000);// 毫秒
        } catch (Exception e) {
        }
        callback.printFinished("打印完成");
    }
}
class People {

    Printer printer = new Printer();
    // 同步回调
    public void goToPrintSyn(Callback callback, String text) {
        printer.print(callback, text);
    }
    // 异步回调
    public void goToPrintASyn(Callback callback, String text) {
        new Thread(new Runnable() {
            public void run() {
                printer.print(callback, text);
            }
        }).start();
    }
}

public class TestCallBack2 {
    public static void main(String[] args) {
        // 测试同步回调
        People people = new People();
        Callback callback = new Callback() {
            @Override
            public void printFinished(String msg) {
                System.out.println("打印机告诉我的消息是 ---> " + msg);
            }
        };
        System.out.println("需要打印的内容是 ---> " + "打印一份简历");
        people.goToPrintSyn(callback, "打印一份简历");
        System.out.println("我在等待 打印机 给我反馈");
        System.out.println("-------------------------------");
        people = new People();
        callback = new Callback() {
            @Override
            public void printFinished(String msg) {
                System.out.println("打印机告诉我的消息是 ---> " + msg);
            }
        };
        System.out.println("需要打印的内容是 ---> " + "打印一份简历");
        people.goToPrintASyn(callback, "打印一份简历");
        System.out.println("我在等待 打印机 给我反馈");

    }
}
