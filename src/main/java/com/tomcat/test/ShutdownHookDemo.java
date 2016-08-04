package com.tomcat.test;

/**
 * Created by Ivan on 2016/7/18.
 */
public class ShutdownHookDemo {
    public void start() {
        System.out.println("Demo");
        ShutdownHook ShutdownHook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(ShutdownHook);//在RunTime上注册一个线程，当程序关闭时执行，一般用来做清理工作
    }

    public static void main(String[] args) {
        ShutdownHookDemo demo = new ShutdownHookDemo();
        demo.start();
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}

class ShutdownHook extends Thread {
    public void run() {
        System.out.println("Shutting down");
    }
}