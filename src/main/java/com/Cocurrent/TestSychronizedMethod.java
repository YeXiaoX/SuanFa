package com.Cocurrent;

/**
 * Created by Ivan on 2016/8/9.
 * 如果一个类里面有两个synchronized方法，则这两个方法是不能同步执行的。
 * 当一个线程进入其中一个方法时，先判断该方法是否有synchronized关键字，如果有就会对这个对象ID加锁，当其他线程要进入这个对象方法时，先检测这个对象ID是否加锁，如果加锁则需要等待锁释放；如果没有则直接进入该方法。
 * 也就是说synchronized锁的作用范围就是这个对象中所有synchronized方法。
 */
public class TestSychronizedMethod {
    private int testNum = 10;

    public synchronized void test1(Thread thread) {
        System.out.println("test1 entry " + thread.getName());
        try {
            thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testNum = 11;
        System.out.println("test1 out " + thread.getName());
    }

    public synchronized void test2(Thread thread) {
        System.out.println("test2 entry " + thread.getName());
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testNum = 12;
        System.out.println("test2 out " + thread.getName());
    }

    public void test3(Thread thread) {
        System.out.println("test3 entry");
        testNum = 13;
        System.out.println("test3 out");
    }

    public static void main(String[] args) {
        final TestSychronizedMethod sychronizedMethod = new TestSychronizedMethod();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                sychronizedMethod.test1(this);//一次执行完毕就释放锁
                sychronizedMethod.test2(this);//需要重新等待获得锁
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                sychronizedMethod.test2(this);
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                sychronizedMethod.test3(this);
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
