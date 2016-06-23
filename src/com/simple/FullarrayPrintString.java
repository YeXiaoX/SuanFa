package com.simple;

/**
 * Created by Ivan on 2016/6/23.
 * 全排列打印一个字符串
 * 考察复杂问题简单化能力
 */
public class FullarrayPrintString {
    public static void print(char aa[], int start) {
        if (aa.length <= 1) {
            System.out.println(new String(aa));
            return;
        }
        if (start == aa.length){
            System.out.println(new String(aa));
            return;
        }

        for (int i = start; i < aa.length; i++) {
            char temp = aa[i];
            aa[i] = aa[start];
            aa[start] = temp;
            print(aa, start + 1);
            temp = aa[i];
            aa[i] = aa[start];
            aa[start] = temp;
        }
    }

    public static void main(String args[]) {
        String test = "abcd";
        char aa[] = test.toCharArray();
        print(aa, 0);

    }
}
