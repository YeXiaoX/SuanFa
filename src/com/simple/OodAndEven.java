package com.simple;

/**
 * Created by Ivan on 2016/6/6.
 * 把一个数组中奇数和偶数分开
 * 考察代码的效率
 */
public class OodAndEven {
    public static void divide(int numbers[]) {
        if (numbers.length <= 0) return;
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] % 2 != 0) start++;
            if (numbers[end] % 2 == 0) end--;
            if (numbers[start] % 2 == 0 && numbers[end] % 2 != 0 && start < end) {
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
            }
        }
    }

    public static void printNums(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void main(String args[]) {
        int numbers[] = {1};
        divide(numbers);
        printNums(numbers);
    }

}
