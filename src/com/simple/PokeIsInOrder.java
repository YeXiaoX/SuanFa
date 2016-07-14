package com.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan on 2016/7/14.
 * 判断扑克牌中随机抽到的五张牌是不是顺子
 * 抽象建模能力
 */
public class PokeIsInOrder {
    public static boolean isInOrder(List<Integer> aa) {
        if (aa.size() != 5) return false;
        Collections.sort(aa);
        int countKing = 0;
        if (aa.get(0) == 0) {
            countKing += 1;
            if (aa.get(1) == 0) {
                countKing += 1;
            }
        }
        int first = aa.get(countKing);
        int num = countKing;
        for (int i = countKing + 1; i < aa.size(); i++) {
            if (aa.get(i) != first + 1) {
                num--;
                first+=2;
            }else {
                first += 1;
            }
        }
        if (num >= 0) return true;
        return false;
    }

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(isInOrder(list));
    }
}
