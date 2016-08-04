package com.simple;

/**
 * Created by Ivan on 2016/6/7.
 * 反转链表
 * 考察思维能力，代码的健壮性
 */
public class RevertLinklist {
    public static void revert(Link head,Link temp,Link last){
        if(head.getNext()!=null){
            Link next = head.getNext();
            head.setNext(temp);
            last.setNext(next.getNext());
            last.setValue(next.getValue());
            revert(next,head,last);
        }else{
            head.setNext(temp);
            last.setNext(head.getNext());
            last.setValue(head.getValue());
        }

    }

    public static void printLink(Link head) {
        if (head == null) return;
        while (head.getNext() != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
        System.out.println(head.getValue());
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
        Link last = new Link();
        revert(link1,null,last);
        printLink(last);
    }
}
