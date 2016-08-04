package com.simple;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Ivan on 2016/5/26.
 * 倒着输出一个链表
 * 考察对基本数据结构的运用
 */
public class RevertLingList {
    public static void revert(LinkedList<String> list){
        Stack stack = new Stack();
        for(String s:list){
            stack.push(s);
        }
      while(!stack.empty()){
           System.out.print(stack.pop());
        }
    }

    public static void revert1(LinkedList<String> list){
        if(list.isEmpty())return;
        String temp = list.peek();
        list.removeFirst();
        revert1(list);
        System.out.println(temp);
    }

    public static void main(String args[]){
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        revert1(list);
    }

}
