package com.simple;

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

    public static void main(String args[]) {
        getLastNum(10, 7);
    }
}
