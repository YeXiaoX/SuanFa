package com.simple;

/**
 * Created by Ivan on 2016/6/1.
 * 计算一个数中的二进制表示中有多少个1
 * 位运算
 */
public class BitCalculate {

    public static void calculate1(int num){
        int count = 0;
        while(num!=0){//这种解法是通过一个数和它减去1后的数做位运算，这样可以把这个数二进制最右边的1变为0，有多少个1就就做多少次运算。
            count++;
            num=num&(num-1);
        }
        System.out.println("1的个数为："+count);
    }

    public static  void calculate(int num){

        int temp = 1;
        int count = 0;
        if(num<0){
            num = Math.abs(num);
            count++;
        }
        while(num>=temp){
            int r = num&temp;
            if(r==temp){
                count++;
            }
            temp = temp<<1;
        }
        System.out.println("1的个数为："+count);
    }
    public static void main(String args[]){
        calculate1(127);
    }
}
