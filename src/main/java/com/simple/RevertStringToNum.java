package com.simple;

import com.sun.deploy.util.StringUtils;

/**
 * Created by Ivan on 2016/7/21.
 * 把字符串转换成数字
 * 考察写代码逻辑的严谨性
 */
public class RevertStringToNum {
    public static void revertStringTon(String aa) {
        if (aa == null || "".equals(aa)) {
            return;
        }
        char strs[] = aa.toCharArray();
        if (strs.length > 19) {
            System.out.println("overflow!");
            return;
        }
        long result = 0l;
        boolean flag = true;
        for (int i = 0; i <= strs.length - 1; i++) {
            if (i == 0) {
                if (strs[i] == '+') {
                    result = result;
                } else if (strs[i] == '-') {
                    flag = false;
                } else {
                    int temp = strs[i] - '0';
                    if (temp >= 0 && temp <= 9) {
                        result = result * 10 + temp;
                    }
                }
            } else {
                int temp = strs[i] - '0';
                if (temp >= 0 && temp <= 9) {
                    result = result * 10 + temp;
                } else {
                    System.out.println("invalid character!");
                    return;
                }
            }
        }
        if (!flag) {
            result = -result;
        }
        System.out.println(result);
    }

    public static void main(String args[]) {
        revertStringTon("-110000000000000000");
    }

}
