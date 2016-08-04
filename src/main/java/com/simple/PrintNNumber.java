package com.simple;

/**
 * Created by Ivan on 2016/6/3.
 * 从0开始打印n位数
 * 考察代码的完整性，n有可能大于基本数据类型
 */
public class PrintNNumber {
    public static void  printNumber(int n){
        if(n<=0)return;
        char number[] = new char[n];
        for(int i = 0;i<n;i++){
            number[i] = '0';
        }
        while(increment(number)){
            printT(number);
        }
    }

    public static boolean increment(char [] number){
        for(int i=number.length-1;i>=0;i--){
            char last = number[i];
            if(last<'9'){
                number[i]+=1;
                return true;
            }else{
                number[i] = '0';
            }
        }
        return false;
    }

    public static void printT(char number[]){
        String result = "";
        for(int i=0;i<number.length;i++){
            if(number[i]=='0'&&"".equals(result)){
                result=result;
            }else{
                result=result+number[i];

            }
        }
        System.out.println(result);
    }

    public static void main(String args[]){
        printNumber(4);
    }
}
