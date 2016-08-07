package com.test.base.java;

import com.test.HelloB;

/**
 * Created by Ivan on 2016/8/3.
 * 多线程下调用一个单例或者静态对象的方法，如果不涉及具体的属性，则不会存在冲突，这个时候内存是能容纳多少个方法调用者的关键
 */

public class TestMethodMultiThread {
    //public static HelloB dog  = new HelloB();
    public static void main(String args[]){
        Thread thread = new Thread(){
            @Override
            public void run() {
                for(int i = 0;i<100;i++) {
                    //dog.test("a");
                    TestThreadLocal.setInteger(3);
                    TestThreadLocal.setNoThreadLocal(6);
                    System.out.println("1:"+TestThreadLocal.getInteger());
                    //System.out.println("1:"+TestThreadLocal.getNoThreadLocal());
                }
            }
        };
        thread.start();
        for(int i = 0;i<100;i++) {
           // dog.test("b");
            System.out.println("2:"+TestThreadLocal.getInteger());
            //System.out.println("2:"+TestThreadLocal.getNoThreadLocal());
        }
    }
}
