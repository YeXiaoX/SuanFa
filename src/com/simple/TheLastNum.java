package com.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 2016/7/15.
 * 圆圈中最后一个数字，0,1.。。。。n-1个数，每次从数字0开始删除第m个数
 * 考察抽象建模能力
 */
public class TheLastNum {
    public static Link getHead(int n) {
        if (n < 1) return null;
        Link head = new Link();
        head.setIntValue(0);
        Link before = head;
        for (int i = 1; i < n; i++) {
            if (i != n - 1) {
                Link next = new Link();
                next.setIntValue(i);
                before.setNext(next);
                before = next;
            } else {
                Link next = new Link();
                next.setIntValue(i);
                before.setNext(next);
                next.setNext(head);
            }
        }
        return head;
    }

    public static Link deleteLink(Link before, Link toDelete) {
        if (toDelete.getNext() != before) {
            before.setNext(toDelete.getNext());
        } else {
            before.setNext(null);
        }
        return before.getNext();
    }

    public static void getLastNum(int n, int m) {
        Link head = getHead(n);
        if (head == null) return;
        Link before = null;
        Link temp = head;
        int tempM = 1;
        while (temp != null) {
            if (tempM == m) {
                temp = deleteLink(before, temp);
                tempM = 1;
            } else {
                before = temp;
                tempM++;
                temp = temp.getNext();
            }
        }
        System.out.println(before.getIntValue());
    }

    //不用循环链表的解法
    public static void getLastNum1(int n, int m) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 1;
        int index = 0;
        while (list.size() > 1) {
            if (index >= list.size()) index = 0;
            if (i == m) {
                // System.out.println(list.get(index));
                list.remove(list.get(index));
                i = 1;
            } else {
                index++;
                i++;
            }
        }
        System.out.println(list.get(0));
    }

    public static void main(String args[]) {
        System.out.println(System.currentTimeMillis());
        getLastNum(10000, 997);
        System.out.println(System.currentTimeMillis());
        getLastNum1(10000, 997);
        System.out.println(System.currentTimeMillis());
        /*

        结果：
        1468587939251
        2647
        1468587939288
        2647
        1468587939334
        * */
        //第二种算法比第一种算法慢，说明了链表的效率比list高
    }
}
