package com.simple;

/**
 * Created by Ivan on 2016/6/2.
 * 最高效的计算一个数的n次方
 */
public class CalculateN {
    public static double power(double base, int export) {
        if (export == 0) return 1;
        if (export == 1) return base;
        double result = power(base, export >> 1);
        result *= result;
        if ((export & 1) == 1) {
            result = result * base;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(power(2, 3));
    }
}
