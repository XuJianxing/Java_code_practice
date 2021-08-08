package com.multithread;

/**
 * 线程A在运行期间，可以调用线程B的join()方法，让线程B和线程A联合。
 * 这样，线程A就必须等待线程B执行完毕后，才能继续执行。
 */
public class JoinTest {
    public static void main(String[] args) {
        System.out.println("father让son买烟的故事: ");
        new Thread(new FatherThread()).start();
    }
}
class FatherThread implements Runnable{
    @Override
    public void run() {
        System.out.println("爸爸想抽烟，发现烟抽完了");
        System.out.println("让儿子去买包烟");
        // 父亲等儿子，所以要启动son线程，让son.join()，father等son线程完成
        Thread son = new Thread(new SonThread());
        son.start();
        System.out.println("father开始等son回来(son.join())");
        try {
            son.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("father需要出门找son了");
            // 结束jvm。如果是0则表示正常结束；否则表示非正常结束
            System.exit(1);
        }
        System.out.println("father把零钱给了son");
    }
}

class SonThread implements Runnable{
    @Override
    public void run() {
        System.out.println("儿子出门去买烟");
        System.out.println("儿子需要10分钟");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("第 "+i+" 分钟");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("son回来了");
    }
}
