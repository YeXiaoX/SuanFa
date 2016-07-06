package com.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan on 2016/7/6.
 * 计算一个排序数组中一个数出现的个数
 * 知识迁移能力
 */
public class GetSortArrayNumberOfN {
    //该方法的时间复杂度是O(N)
    public static void getNumber(int aa[], int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < aa.length; i++) {
            if (map.get(aa[i]) == null) {
                map.put(aa[i], 1);
            } else {
                map.put(aa[i], map.get(aa[i]) + 1);
            }
        }
        System.out.println(map.get(n));
    }

    //该方法的时间复杂度为O(logn)
    public static void getNumber1(int aa[], int n) {
        int start = getFirst(aa, 0, aa.length - 1, n);
        int last = getLast(aa, 0, aa.length - 1, n);
        if (last != 0) last = last + 1;
        System.out.println(last - start);
    }

    public static int getFirst(int aa[], int start, int end, int n) {
        if (start > end || start > aa.length - 1 || start < 0) return -1;
        int min = (start + end) / 2;
        if (aa[min] == n) {
            if ((min > 0 && aa[min - 1] != n) || min == 0) {
                return min;
            } else {
                end = min - 1;
            }
        } else if (aa[min] > n) {
            end = min - 1;
        } else {
            start = min + 1;
        }
        return getFirst(aa, start, end, n);
    }

    public static int getLast(int aa[], int start, int end, int n) {
        if (start > end || start > aa.length - 1 || start < 0) return -1;
        int min = (start + end) / 2;
        if (aa[min] == n) {
            if ((min < end && aa[min + 1] != n) || min == end) {
                return min;
            } else {
                start = min + 1;
            }
        } else if (aa[min] > n) {
            end = min - 1;
        } else {
            start = min + 1;
        }
        return getLast(aa, start, end, n);
    }

    public static void main(String args[]) {
        int aa[] = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(System.currentTimeMillis());
        getNumber(aa, 3);
        System.out.println(System.currentTimeMillis());
        getNumber1(aa, 3);
        System.out.println(System.currentTimeMillis());
    }
}
