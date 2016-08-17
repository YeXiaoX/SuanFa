package com.Cocurrent.test;

import com.Cocurrent.ReadAndWriteLock;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhanghui on 2016/8/16.
 */
public class TestReadAndWrite {
    public static void main(String args[]){
        Map<String,String> map = new HashMap<String, String>();
        final ReadAndWriteLock rw = new ReadAndWriteLock<String, String>(map);
        int i  = 0;
        Thread write = new Thread(){
            @Override
            public void run() {
                for(int j = 0;j<100;j++) {
                    System.out.println("write:"+rw.put("s:"+j, "aa"+j+1));
                }
            }
        };

        Thread read = new Thread(){
            @Override
            public void run() {
                for(int j = 0;j<100;j++) {
                   System.out.println(rw.get("s:"+j));
                }
            }
        };

        write.start();
        read.start();

    }
}
