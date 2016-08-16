package com.Cocurrent;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Zhanghui on 2016/8/16.
 * 读写锁
 */
public class ReadAndWriteLock<K,V> {
    private final Map<K,V> map;
    private final ReadWriteLock lock  = new ReentrantReadWriteLock();
    private final Lock  w = lock.writeLock();
    private  final Lock r = lock.readLock();

    public ReadAndWriteLock(Map<K, V> map) {
        this.map = map;
    }

    public V put(K k,V v){
        w.lock();
        try {
            return map.put(k,v);
        } finally {
            w.unlock();
        }
    }

    public V get(K k){
        r.lock();
        try {
            return map.get(k);
        } finally {
            r.unlock();
        }
    }
}
