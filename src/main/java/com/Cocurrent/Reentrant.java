package com.Cocurrent;

/**
 * Created by Ivan on 2016/8/8.
 * 重入
 */
public class Reentrant {
    public Reentrant() {
        System.out.println("father");
    }

    public synchronized void doSomething(Thread thread, long c){
        try {
            System.out.println("super sleep "+c);
            thread.sleep(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("super do something");
    }
}
