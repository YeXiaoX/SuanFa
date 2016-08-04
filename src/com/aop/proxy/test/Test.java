package com.aop.proxy.test;

import java.lang.reflect.Proxy;

/**
 * Created by Ivan on 2016/8/4.
 * 实现spring aop的增强的demo
 */
public class Test {
    public static void main(String args[]) {
        TestService target = new TestServiceImpl();

        PerformanceHandler handler = new PerformanceHandler(target);

        TestService proxy = (TestService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);//代理testService接口

        proxy.test("ss");

        System.out.println(proxy.test1(2));
    }
}
