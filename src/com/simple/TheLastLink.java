package com.simple;

import java.util.LinkedList;

/**
 * Created by Ivan on 2016/6/6.
 * 链表的倒数第K个节点
 * 考察代码的健壮性
 */
public class TheLastLink {
    public static  Link lastLink(Link head,int k) {
        if(head==null)return null;
        int size = 1;
        Link temp = head;
        while(temp.getNext()!=null){
            size++;
            temp = temp.getNext();
        }
        if(k>size||k<=0)return null;
        int count = 0;
        while(count<size-k){
            count++;
            head=head.getNext();
        }
        return head;
    }
    public static void main(String args[]){
        Link link1 = new Link();
        link1.setValue("1");
        Link link2 = new Link();
        link2.setValue("2");
        Link link3 = new Link();
        link3.setValue("3");
        link1.setNext(link2);
        link2.setNext(link3);
        link3.setNext(null);
        Link result = lastLink(link1,4);
        if(result!=null) {
            System.out.println(result.getValue());
        }
    }
}
