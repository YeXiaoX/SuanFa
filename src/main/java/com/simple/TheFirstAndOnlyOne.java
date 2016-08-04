package com.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan on 2016/7/4.
 * 字符串中第一个只出现一次的字符
 * 时间效率和空间效率的权衡
 */
public class TheFirstAndOnlyOne {
    public static void getFirstOnlyOne(String strs) {
        if (strs == "" || strs.length() == 0) return;
        char aa[] = strs.toCharArray();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> index = new HashMap<String, Integer>();
        for (int i = 0; i < aa.length; i++) {
            if (map.get(aa[i] + "") == null) {
                map.put(aa[i] + "", 1);
                index.put(aa[i] + "", i);
            } else {
                Integer temp = map.get(aa[i]+"");
                map.put(aa[i] + "", temp + 1);
                index.put(aa[i] + "", i);
            }
        }
        String result = "";
        int resultIndex = aa.length - 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (index.get(entry.getKey()) < resultIndex) {
                    result = entry.getKey();
                    resultIndex = index.get(entry.getKey());
                }
            }
        }
        System.out.println(result);

    }

    public static void main(String args[]) {
        String aa = "agbacdcdeff";
        getFirstOnlyOne(aa);
    }
}
