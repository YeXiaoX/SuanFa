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
    private final ExecutorService productService;
    private final ExecutorService consumerService;
    private final BlockingQueue<String> queue;

    ExecutorTest(ExecutorService executorService,BlockingQueue<String> queue,ExecutorService consumerService) {
        this.productService = executorService;
        this.queue = queue;
        this.consumerService = consumerService;
    }

    public void exec(String aa[]) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, aa);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(productService);
        CompletionService<String> completionService1 = new ExecutorCompletionService<String>(consumerService);
        for (final String s : list) {
            completionService.submit(new Callable<String>() {
                public String call() throws Exception {
                    queue.add(s);
                    return s+":"+queue.size();
                }
            });
        }

        while(queue.size()>0){
            completionService1.submit(new Callable<String>() {
                public String call() throws Exception {
                    return queue.take();
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
                    //Thread.currentThread().interrupt();//这里中断会报异常,然后consumer将无法执行
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

        try {
            for (int i = 0; i < list.size(); i++) {
                Future<String> f = completionService1.take();
                System.out.println(f.cancel(true));//取消正在完成的任务,返回结果为false表示任务已经完成
                String result = f.get();
                System.out.println("结果为："+result);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ExecutorService es = Executors.newCachedThreadPool();
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(4);
        ExecutorService consumer = Executors.newCachedThreadPool();
        ExecutorTest e = new ExecutorTest(es,queue,consumer);
        e.exec(new String[]{"1", "2", "3", "4"});
        es.shutdown();
        consumer.shutdown();
        try {
            consumer.awaitTermination(3,TimeUnit.SECONDS);//当调用了shutdown方法时调用，表示阻塞直到所有的任务都被执行，这里阻塞三秒
        } catch (Exception e1) {
            e1.printStackTrace();
        }
//       Thread t = new Thread(new Task());
//        t.run();//当做普通方法调用，不会实现多线程异步调用,如果用t.start()则表示从一个线程的完整生命周期开始，显示创建一个线程，调用start后表示线程就绪，调用run方法
        //表示线程执行，然后是线程阻塞和结束
        System.exit(0);
    }
}

class Task implements Runnable {
    public void run() {
        System.out.println("aa");
    }
}

