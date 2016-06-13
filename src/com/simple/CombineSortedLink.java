package com.simple;

/**
 * Created by Ivan on 2016/6/8.
 * 合并两个有序的链表
 */
public class CombineSortedLink {
    public static void combineLink(Link a,Link b,Link result){
        int aValue = 0;
        int bValue = 0;
        if(a==null&&b==null)return;
        if(a!=null)aValue = a.getIntValue();
        if(b!=null)bValue = b.getIntValue();
        if(aValue<bValue&&a!=null){
            result.setNext(a);
            combineLink(a.getNext(),b,result.getNext());
        }else if(b!=null){
            result.setNext(b);
            combineLink(a,b.getNext(),result.getNext());
        }
    }

    public static void printLink(Link head) {
        if (head == null) return;
        while (head.getNext() != null) {
            System.out.println(head.getIntValue());
            head = head.getNext();
        }
        System.out.println(head.getIntValue());
    }

    public static void main(String args[]){
        Link a = new Link();
        a.setIntValue(1);
        Link alink2 = new Link();
        alink2.setIntValue(3);
        Link alink3 = new Link();
        alink3.setIntValue(5);
        a.setNext(alink2);
        alink2.setNext(alink3);
        alink3.setNext(null);
        Link b = new Link();
        b.setIntValue(2);
        Link blink2 = new Link();
        blink2.setIntValue(4);
        Link blink3 = new Link();
        blink3.setIntValue(6);
        b.setNext(blink2);
        blink2.setNext(blink3);
        blink3.setNext(null);
        Link result = new Link();
        int aValue = 0;
        int bValue = 0;
        if(a!=null)aValue = a.getIntValue();
        if(b!=null)bValue = b.getIntValue();
        if(aValue<bValue){
           result = a;
            a = a.getNext();
        }else{
           result = b;
            b = b.getNext();
        }
        combineLink(a,null,result);
        printLink(result);
    }
}
