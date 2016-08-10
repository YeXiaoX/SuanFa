package com.Cocurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Ivan on 2016/8/10.
 * 把一个任务交给一个线程池去处理，并返回处理结果
 */
public class ExecutorTest {
    private final ExecutorService executorService;

    ExecutorTest(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void exec(String aa[]) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, aa);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
        for (final String s : list) {
            completionService.submit(new Callable<String>() {
                public String call() throws Exception {
                    int sum = 0;
                    for(int i=0;i<1000000;i++)
                        sum += i;
                    return s+":"+sum;
                }
            });
        }
        try {
            for (int i = 0; i < list.size(); i++) {
                Future<String> f = completionService.take();
                System.out.println(f.cancel(true));//取消正在完成的任务,返回结果为false表示任务已经完成
                String result = f.get();
                System.out.println(result);
                if (i == 2) {
                    Thread.currentThread().interrupt();//这里中断会报异常
                }
            }
        } catch (InterruptedException e) {
            System.out.println("线程中断");
            System.out.println("线程是否中断：" + Thread.currentThread().isInterrupted());
            Thread.currentThread().interrupt();
            System.out.println("线程是否中断1：" + Thread.currentThread().isInterrupted());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorTest e = new ExecutorTest(es);
        e.exec(new String[]{"1", "2", "3", "4"});
    }
}

class Task implements Runnable {
    public void run() {
        System.out.println("aa");
    }
}

