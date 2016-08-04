package com.aop.proxy.test;

/**
 * Created by Ivan on 2016/8/4.
 * ThreadLocal负责实现一个线程一个性能检测的对象
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();

    public static void begin(String method){
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end(){
        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecord.get();

        mp.printPerformance();
    }
}
