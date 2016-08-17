package com.Cocurrent.test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ivan on 2016/8/8.
 */
public class TestAtomic {
    private final static AtomicLong count = new AtomicLong(0);

    public static void main(String args[]){
        Thread thread  = new Thread(){
            @Override
            public void run() {
               for(int i = 0;i<1000;i++){
                   count.incrementAndGet();
                   System.out.println("1:"+count.get());
               }
            }
        };
        thread.start();
        for(int i = 0;i<1000;i++){
            count.incrementAndGet();
            System.out.println("2:"+count.get());
        }
    }
}
