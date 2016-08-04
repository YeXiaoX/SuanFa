package com.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/3 0003.
 * 报数去掉n的倍数
 */
public class DeleteNumByOrder {
    public static void deleteByNum(int n, List<Integer> list) {
        int i = 1;
        int index = 0;
        while (list.size() > 1) {
            if (index >= list.size()) index = 0;
            if (i % n == 0) {
               // System.out.println(list.get(index));
                list.remove(list.get(index));
            }
            index++;
            i++;
        }
        System.out.println(list.get(0));
    }

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        deleteByNum(7, list);

    }

}
