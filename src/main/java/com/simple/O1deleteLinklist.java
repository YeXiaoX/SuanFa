package com.simple;

/**
 * Created by Ivan on 2016/6/4.
 * 在O(1)的时间复杂度内删除链表中一个元素
 * 考察思维能力
 * 算法中涉及java参数传递，在方法中改变对象的地址导致算法失败
 */
public class O1deleteLinklist {
    public static void delete(Link head, Link toDelete) {

        if (head == null) return;
        if (head == toDelete) {
            head = new Link();
            System.gc();
            return;
        }
        if (toDelete.getNext() == null) {
            toDelete = null;
            return;
        }
        Link toDeleteNext = toDelete.getNext();
        toDelete.setValue(toDeleteNext.getValue());
        toDelete.setNext(toDeleteNext.getNext());
        toDeleteNext = null;
    }

    public static void printLink(Link head) {
        if (head == null) return;
        while (head.getNext() != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
        System.out.println(head.getValue());
    }


    public static void main(String args[]) {
      Link head = new Link();
        head.setValue("head");
        Link one = new Link();
        one.setValue("one");
        Link two = new Link();
        two.setValue("two");
        Link three = new Link();
        three.setValue("three");
        head.setNext(one);
        one.setNext(two);
        two.setNext(three);
        three.setNext(null);
        printLink(head);
        delete(head,head);
        printLink(head);


    }

}

