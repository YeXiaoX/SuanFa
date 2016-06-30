package com.simple;

/**
 * Created by Ivan on 2016/6/29.
 * 从1到n个整数中1出现的个数
 * 时间效率
 */
public class TheNumberOf1 {
    public static int getNumber(int n) {//该方法算法复杂度为n*logn
        int number = 0;
        for (int i = 1; i <= n; i++) {
            number += theNumber(i);
        }
        return number;
    }

    public static int theNumber(int n) {
        if (n <= 0) return 0;
        int number = 0;
        while (n > 0) {
            int temp = n % 10;
            if (temp == 1) number++;
            n = n / 10;
        }
        return number;
    }

    public static int getNumber1(int n){
        return 0;
    }

    public static void main(String args[]){
        System.out.println(getNumber(1000));
    }
}
