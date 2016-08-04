package com.simple;

import java.util.List;

/**
 * Created by Ivan on 2016/6/27.
 * 最小的K个数
 * 考察优化时间和空间效率
 */
public class TheBigKNum {

    public static void getBigK(int aa[], int start, int end, int k) {
        if (k > aa.length || start >= end || start < 0 || end > aa.length - 1) return;
        int i = start;
        int j = end;
        int index = partion(aa, i, j);
        System.out.println("index:"+index);
        while (index != k - 1) {
            if (index < k - 1) {
                i = index+1;
                index = partion(aa, i, j);
            }
            else {
                j = index-1;
                index = partion(aa, i, j);
            }
        }
        for(int x=0;x<k;x++){
            System.out.println(aa[x]);
        }
    }


    public static int partion(int aa[], int start, int end) {//快速排序算法
        if (start >= end || start < 0 || end > aa.length - 1) return start;
        int i = start;
        int j = end;
        int flag = aa[start];
        while (start < end) {
            while (end > start && aa[end] > flag) end--;
            if (end > start) {
                int temp = aa[end];
                aa[end] = aa[start];
                aa[start] = temp;
            }
            while (start < end && aa[start] < flag) start++;
            if (start < end) {
                int temp = aa[end];
                aa[end] = aa[start];
                aa[start] = temp;
            }
//             if (start > i) partion(aa, i, start);
//             if (start < j) partion(aa, start + 1, j);
        }
        return start;
    }

    public static void main(String args[]) {
        int aa[] = {3, 5, 6, 4, 1, 2, 7};
//        partion(aa, 0, 6);
//        for (int i = 0; i < aa.length; i++) {
//            System.out.println(aa[i]);
//        }
        getBigK(aa,0,6,2);
    }
}
