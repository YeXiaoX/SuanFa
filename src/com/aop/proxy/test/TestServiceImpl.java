package com.aop.proxy.test;

/**
 * Created by Ivan on 2016/8/4.
 */
public class TestServiceImpl implements TestService {
    @Override
    public int test1(int i) {
        return i+1;
    }

    @Override
    public void test(String s) {
        System.out.println(s);
    }
}
