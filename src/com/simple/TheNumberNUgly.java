package com.simple;

/**
 * Created by Ivan on 2016/7/1.
 * 按大小顺序排列的第N个丑数（只包含因子2,3,5的数，1也是）
 * 空间效率和时间效率的取舍
 */
public class TheNumberNUgly {
    public static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1 ? true : false;
    }

    /*耗时间的解法*/
    public static int getNum(int index) {
        if (index <= 0) return 0;
        int flag = 0;
        int num = 0;
        while (flag < index) {
            ++num;
            if (isUgly(num)) {
                flag++;
            }
        }
        return num;
    }

    /*耗空间的解法*/
    public static int getNum1(int index) {
        if (index <= 0) return 0;
        int aa[] = new int[index];
        aa[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int flag = 1;
        while (flag < index) {
            int min = getMin(index2, index3, index5, aa);
            aa[flag] = min;
            while (aa[index2] * 2 <= aa[flag]) index2++;
            while (aa[index3] * 3 <= aa[flag]) index3++;
            while (aa[index5] * 5 <= aa[flag]) index5++;
            flag++;
        }
        return aa[flag-1];
    }

    public static int getMin(int num2, int num3, int num5, int aa[]) {
        int min = aa[num2] * 2 < aa[num3] * 3 ? aa[num2] * 2 : aa[num3] * 3;
        min = min < aa[num5] * 5 ? min : aa[num5] * 5;
        return min;
    }

    public static void main(String args[]) {
        System.out.println(System.currentTimeMillis());
        System.out.println(getNum(1000));
        System.out.println(System.currentTimeMillis());

        System.out.println(getNum1(1000));
        System.out.println(System.currentTimeMillis());

    }

}
