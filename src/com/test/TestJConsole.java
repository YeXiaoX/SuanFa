package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 2016/6/3.
 */
public class TestJConsole {
    static class oomObject{
        public byte[]placeHolder = new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<oomObject> list = new ArrayList<oomObject>();
        for(int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new oomObject());
        }

    }

    public static void main(String args[]) throws InterruptedException {
        fillHeap(1000);
        System.gc();
    }
}
