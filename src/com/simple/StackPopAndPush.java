package com.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ivan on 2016/6/16.
 * 栈的压入和弹出序列
 * 考察分析复杂问题的能力
 */
public class StackPopAndPush {
    public static boolean isStack(List<Integer> in, List<Integer> out, Stack main) {
        int count = 0;
        for (int num = 0; num < in.size(); num++) {
            main.push(in.get(num));
            while (!main.isEmpty()&&out.get(count) == main.peek()) {
                System.out.println(main.pop());
                count++;
            }
        }
        while (count < out.size()) {
            if ( !main.isEmpty()&&main.peek() == out.get(count)) {
                System.out.println(main.pop());
            }
            count++;
        }
        if (main.isEmpty()) return true;
        return false;

    }

    public static void pushStack(Stack stack, int in[]) {
        for (int i = 0; i < in.length; i++) {
            stack.push(in[i]);
        }
    }

    public static void main(String args[]) {
        List<Integer> in = new ArrayList<Integer>();
        List<Integer> out = new ArrayList<Integer>();
        in.add(1);
        in.add(2);
        in.add(3);
        in.add(4);
        in.add(5);
        out.add(4);
        out.add(3);
        out.add(5);
        out.add(1);
        out.add(2);
        Stack stack = new Stack();
//        Integer a = in.get(3);
//        Integer b = out.get(0);
//        System.out.println(a == b);
        System.out.println("isStack:" + isStack(in, out, stack));

    }
}
