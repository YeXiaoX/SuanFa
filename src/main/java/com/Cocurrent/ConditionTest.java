package com.Cocurrent;

import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Zhanghui on 2016/8/17.
 * 引入condition，保证在map为空时不会get，在map满的时候不会put
 */
public class ConditionTest {
    private Lock lock = new ReentrantLock();
    private Condition put = lock.newCondition();
    private Condition get = lock.newCondition();
    int count = 0;
    public Map<String, String> map;

    public ConditionTest(int count, Map<String, String> map) {
        this.count = count;
        this.map = map;
    }

    public String get(String key) {
        lock.lock();
        try {
            while (count == 0) get.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return map.get(key);
        } finally {
            count--;
            map.remove(key);
            put.signal();
            lock.unlock();
        }
    }

    public String put(String key, String value) {
        lock.lock();
        try {
            while (count >= 100) put.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return map.put(key, value);
        } finally {
            count++;
            get.signal();
            lock.unlock();
        }
    }
}
