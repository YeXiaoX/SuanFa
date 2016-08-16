package com.Cocurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Zhanghui on 2016/8/16.
 */
public class ReetrantLock {
    private Lock lock ;
    private Condition condition;
    public ReetrantLock() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        System.out.println("super father");
    }

    public void doSomething(Thread thread, long c){
        //lock.lock();
        /*
        如果不加lockInterruptibly(),当发生中断时，则优先处理中断，这里就是线程不会sleep，而直接向下执行
        如果加lockInterruptibly(),当发生中断时，先抛出异常，由上级调用者处理异常，在这里就是继续sleep
        * */
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("super sleep "+c);
            thread.sleep(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("super do something");
        condition.signalAll();
        lock.unlock();
    }

    public void doOtherthing(){
        lock.lock();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("super do other thing");
        //condition.signalAll();
       lock.unlock();//reentrantLock是重入锁，当这里不释放锁时，当前锁的持有线程可以进入执行这个方法，其他线程不能，synchronized也是可重入锁
    }
}
