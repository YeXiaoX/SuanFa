package com.Cocurrent;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Ivan on 2016/8/9.
 * 在多线程环境下使用hashmap可能导致死循环
 * 因为如果多线程对同一个hashmap执行put操作，当表的大小大于初始值时必然会有rehash过程，如果两个线程同时rehash时，可能导致链表中
 * 产生闭合回路，则在get的时候就会陷入死循环
 */
public class ConCurrentHashMap {
    public static void main(String args[]){
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }

            }
        }, "ftf");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
