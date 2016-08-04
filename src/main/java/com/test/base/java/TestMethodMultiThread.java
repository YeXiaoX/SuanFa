package com.test.base.java;

import com.test.HelloB;

/**
 * Created by Ivan on 2016/8/3.
 * 多线程下调用一个单例或者静态对象的方法，如果不涉及具体的属性，则不会存在冲突，这个时候内存是能容纳多少个方法调用者的关键
 */

public class TestMethodMultiThread {
    public static HelloB dog  = new HelloB();
    public static void main(String args[]){
        Thread thread = new Thread(){
            @Override
            public void run() {
                for(int i = 0;i<100000;i++) {
                    dog.test("a");
                }
            }
        };
        thread.start();
        for(int i = 0;i<100000;i++) {
            dog.test("b");
        }
    }
}
