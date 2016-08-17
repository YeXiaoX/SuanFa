package com.Cocurrent.test;

import com.Cocurrent.ConditionTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhanghui on 2016/8/17.
 */
public class TestCondition {
    public static void main(String args[]){
        Map<String,String> map = new HashMap<String, String>();
        final ConditionTest ct = new ConditionTest(0,map);
        Thread write = new Thread(){
            @Override
            public void run() {
                for(int j = 0;j<100;j++) {
                    System.out.println("write:"+ct.put("s:"+j, "aa"+j+1));
                }
            }
        };

        Thread read = new Thread(){
            @Override
            public void run() {
                for(int j = 0;j<100;j++) {
                    System.out.println(ct.get("s:"+j));
                }
            }
        };

        write.start();
        read.start();

    }

}
