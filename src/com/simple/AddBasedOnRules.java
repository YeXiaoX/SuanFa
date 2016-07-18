package com.simple;

/**
 * Created by Ivan on 2016/7/18.
 * 做加法：从1-n，要求不能使用乘除法，for、while、if、else、switch、case等关键字及条件判断语句
 * 考察发散思维能力
 */
public class AddBasedOnRules {

    //利用短路的特性终止递归
    public static int nFactorial(int n) {
        int num = 0;
        boolean a = (n > 0) && ((num = n + nFactorial(n - 1)) > 0);
        return num;
    }

    public static void main(String args[]) {
        int result = nFactorial(100000);//递归如果层级太深会栈溢出
        System.out.println(result);

    }

}
