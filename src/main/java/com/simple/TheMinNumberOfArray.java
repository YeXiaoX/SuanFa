package com.simple;

/**
 * Created by Ivan on 2016/6/30.
 * 把一个整数数组排列成最小的数
 * 考察时间效率
 */
public class TheMinNumberOfArray {
    public static String getMin(int aa[]) {
        String strs[] = new String[aa.length];
        for (int i = 0; i < aa.length; i++) {
            strs[i] = aa[i] + "";
        }
        sortStr(strs, 0, strs.length - 1);
        String result = "";
        for (String s : strs) {
            result += s;
        }
        return result;
    }

    public static void sortStr(String aa[], int start, int end) {
        if (aa.length < 1 || start >= end || end > aa.length - 1 || start < 0) return;
        String flag = aa[start];
        int i = start;
        int j = end;
        while (start < end) {
            while (end > start && compare(flag, aa[end])) end--;
            if (end > start && !compare(flag, aa[end])) {
                String temp = aa[start];
                aa[start] = aa[end];
                aa[end] = temp;
            }
            while (start < end && compare(aa[start], flag)) start++;
            if (start < end && !compare(aa[start], flag)) {
                String temp = aa[start];
                aa[start] = aa[end];
                aa[end] = temp;
            }
        }
        sortStr(aa, i, start);
        sortStr(aa, start + 1, j);

    }

    public static boolean compare(String a, String b) {
        long aa = Long.parseLong(a + b);
        long bb = Long.parseLong(b + a);
        if (aa < bb) return true;
        return false;
    }

    public static void main(String args[]) {
        int aa[] = {3, 32, 321,4,21};
        System.out.println(getMin(aa));
    }
}
