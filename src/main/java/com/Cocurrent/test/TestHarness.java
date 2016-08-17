package com.Cocurrent.test;

import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Ivan on 2016/8/9.
 * 测试闭锁
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();//所有新建线程执行到这里等待，知道start的count值为0时一起开始往下执行
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();//当内部计数为0时唤醒所有等待的线程
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();//返回当前时间，不能进行日期计算
        startGate.countDown();//把start的count值置为0，开始执行任务
        endGate.await();//等待所有的任务执行完
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String args[]){
        TestHarness t = new TestHarness();
        Runnable r = new TimerTask() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };
        try {
            System.out.println(t.timeTasks(10,r));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
