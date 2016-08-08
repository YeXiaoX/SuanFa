package com.Cocurrent;

/**
 * Created by Ivan on 2016/8/8.
 */
    public class Test extends Thread {
        public static void main(String[] args) {
            for (int i = 1; i <= 2; i++) {
                new Test().start();
            }
        }

        public void run() {
            System.out.print("1");
            yield();//线程让步，当前线程暂停，让其他线程（包括当前线程）执行，如果没有其他线程则继续执行
            System.out.print("2");
        }
}
