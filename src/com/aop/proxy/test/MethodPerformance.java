package com.aop.proxy.test;

/**
 * Created by Ivan on 2016/8/4.
 * 性能监控
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - begin;

        System.out.println(serviceMethod+"花费"+elapse+"毫秒。");
    }
}
