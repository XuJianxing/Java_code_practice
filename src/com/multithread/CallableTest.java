package com.multithread;

import java.util.concurrent.*;

/**
 * Callable 使用线程池实现
 */
public class CallableTest{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableRacer racer = new CallableRacer();
        // 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 提交执行：
        Future<Integer> future1 = executorService.submit(racer);
        Future<Integer> future2 = executorService.submit(racer);
        // 获取结果
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        System.out.println(result1 + " vs " + result2);
        // 关闭服务
        executorService.shutdownNow();
    }
}
class CallableRacer implements Callable<Integer>{
    private String winner;
    @Override
    public Integer call() throws InterruptedException {
        for (int step = 0; step < 100; step++) {
            // 模拟休息 ( Callable里没有线程名，所以equals rabbit没有触发
            if (Thread.currentThread().getName().equals("rabbit") && step % 10 == 0){
                Thread.sleep(100);
            }
            System.out.println(Thread.currentThread().getName()+": "+step);
            if (gameOver(step)) return step;  // 如果结束，直接返回，不再循环
        }
        return null;
    }
    private boolean gameOver(int step){
        if (winner != null) return true;
        else {
            if (step == 100 - 1){  // 判断是否结束 因为循环里是<100，所以要100-1
                winner = Thread.currentThread().getName();
                System.out.println("winner: "+winner);
                return true;
            }
            else return false;
        }
    }
}
