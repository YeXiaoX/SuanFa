package com.simple;

/**
 * Created by Ivan on 2016/6/14.
 * 顺时针打印矩阵
 * 考察画图分析问题的能力
 */
public class PrintMatrix {
    public static void printMa(Object[][] objects) {
        int row = objects.length;
        int colum = objects[0].length;
        int num = row / 2;
        for (int i = 0; i < num; i++) {
            for (int a = i; a < colum - i; a++) {
                System.out.println(objects[i][a]);
            }
            for (int b = i; b < row - i; b++) {
                if(b!=i) {
                    System.out.println(objects[b][colum - i-1]);
                }
            }
            for (int c = colum - i - 1; c >= i; c--) {
                if(c!=colum-i-1) {
                    System.out.println(objects[row - i - 1][c]);
                }
            }
            for (int d = row - i - 1; d >= i; d--) {
                if(d!=row-i-1) {
                    System.out.println(objects[d][i]);
                }
            }
        }
    }

    public static void main(String args[]) {
        Integer mats[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMa(mats);
    }
}
