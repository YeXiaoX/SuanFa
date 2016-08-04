package com.simple;

import java.util.Stack;

/**
 * Created by Ivan on 2016/7/5.
 * 寻找两个链表的第一个相同节点
 * 时间效率和空间效率的权衡
 */
public class SameLinkOfLinklist {
    public static void getLink(Link link1, Link link2) {
        Stack<Link> stack1 = new Stack<Link>();
        Stack<Link> stack2 = new Stack<Link>();
        int count1 = 0;
        int count2 = 0;
        int index = 0;
        while (link1 != null) {
            count1++;
            stack1.push(link1);
            link1 = link1.getNext();
        }
        while (link2 != null) {
            count2++;
            stack2.push(link2);
            link2 = link2.getNext();
        }
        index = count2;
        if (count1 < count2) {
            index = count1;
        }
        Link result = null;
        for (int i = 0; i < index; i++) {
            Link temp1 = stack1.pop();
            Link temp2 = stack2.pop();

            if (temp1 != temp2) {
                System.out.println("ss:"+result.getValue());
                return;
            }
            result = temp1;
        }

    }

    public static void main(String args[]) {
        Link link1 = new Link();
        link1.setValue("1");
        Link link2 = new Link();
        link2.setValue("2");
        Link link3 = new Link();
        link3.setValue("3");
        Link link4 = new Link();
        link4.setValue("4");
        Link link5 = new Link();
        link5.setValue("5");
        Link link6 = new Link();
        link6.setValue("6");
        Link link7 = new Link();
        link7.setValue("7");

        link1.setNext(link2);
        link2.setNext(link3);
        link3.setNext(link6);
        link6.setNext(link7);
        link4.setNext(link5);
        link5.setNext(link6);
        link7.setNext(null);
        getLink(link1, link4);
    }
}
