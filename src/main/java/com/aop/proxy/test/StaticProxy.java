package com.aop.proxy.test;

/**
 * Created by Ivan on 2016/8/4.
 */
public class StaticProxy {
    private TestServiceImpl testService;

    public StaticProxy(TestServiceImpl testService) {
        this.testService = testService;
    }

    public void test(String s){
        PerformanceMonitor.begin("test");
        testService.test(s);
        PerformanceMonitor.end();
    }

    public int test1(int a){
        PerformanceMonitor.begin("test1");
        int re = testService.test1(a);
        PerformanceMonitor.end();
        return re;
    }
}
