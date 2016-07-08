package com.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 2016/7/8.
 * 在一个数组中只有两个数字只出现一次，其他数字都出现两次，找到这两个数字
 * 只是迁移能力
 */
public class FindTwoOnlyOne {
    public static void getNums(int aa[]) {
        int divideFlag = 0;
        for (int i = 0; i < aa.length; i++) {
            divideFlag = aa[i] ^ divideFlag;//通过某一位是否为1把数组分为两个数组，然后通过对拆分后的数组进行异或运算得到只出现一次的数字
        }
        List<Integer> aa1 = new ArrayList<Integer>();
        List<Integer> aa2 = new ArrayList<Integer>();
        for (int j = 0; j < aa.length; j++) {
            if ((divideFlag & aa[j]) != 0) {
                aa1.add(aa[j]);
            } else {
                aa2.add(aa[j]);
            }
        }
        getOne(aa1);
        getOne(aa2);
    }

    public static void getOne(List<Integer> aa) {
        int result = 0;
        for (Integer a : aa) {
            result = result ^ a;
        }
        System.out.println(result);
    }

    public static void main(String args[]) {
        int aa[] = {2, 4, 3, 6, 3, 2, 5, 5};
        getNums(aa);
    }
}
