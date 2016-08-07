package com.simple;

import java.util.*;

/**
 * Created by Ivan on 2016/6/3.
 * 计算N个数和的可能性，2-n个数的和
 * 考察代码的完整性，n有可能大于基本数据类型
 */
public class CalculaeNNumber {
    public static HashSet<Integer> printNumber(int n, int aa[]) {
        if (n <= 0) return null;
        char number[] = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        HashSet<Integer> set = new HashSet<Integer>();
        while (increment(number)) {
            String temp = printT(number);
            char rr[] = temp.toCharArray();
            int res = 0;
            boolean flag = true;
            if (rr.length > 1) {
                HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
                for (int i = 0; i < rr.length; i++) {
                    int num = rr[i]-'0';
                    if(num<aa.length&&!map.containsKey(num)) {
                        res += aa[num];
                    }else{
                        flag = false;
                    }
                    map.put(num,num);
                }
                if(flag) {
                    set.add(res);
                    System.out.println(temp+":"+res);
                }
                flag = true;
            }
        }
        return set;
    }

    public static boolean increment(char[] number) {
        for (int i = number.length - 1; i >= 0; i--) {
            char last = number[i];
            if (last < number.length+'0') {
                number[i] += 1;
                return true;
            } else {
                number[i] = '0';
            }
        }
        return false;
    }

    public static String printT(char number[]) {
        String result = "";
        for (int i = 0; i < number.length; i++) {
            if (number[i] == '0' && "".equals(result)) {
                result = result;
            } else {
                result = result + number[i];

            }
        }
        //System.out.println(result);
        return result;
    }

    public static void main(String args[]) {
        int aa[] = {5, 1, 2, 6};
        HashSet<Integer> set =  printNumber(4, aa);
        List<Integer> list = new ArrayList<Integer>();
        for(Integer i:set){
            list.add(i);
            System.out.println(i);
        }
        Collections.sort(list);


    }
}
