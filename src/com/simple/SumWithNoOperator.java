package com.simple;

/**
 * Created by Ivan on 2016/7/19.
 * 不用运算符实现两个数相加
 * 发散思维能力
 */
public class SumWithNoOperator {
    public static int sum(int a, int b) {
        int noCarry = a ^ b;  //先做异或运算，不进位
        int carry = 0;
        int temp = a & b; //再做与运算
        if (temp != 0) {
            carry = (a & b) << 1;//如果运算有进位则左移一位，然后再和异或运算结果相加，直到没有进位，输出结果
            return sum(noCarry, carry);
        } else {
            return noCarry;
        }
    }

    public static void main(String args[]) {
        System.out.println("result:" + sum(1000000000, -1000000000));
    }

}
