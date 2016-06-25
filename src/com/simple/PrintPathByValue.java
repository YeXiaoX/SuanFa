package com.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ivan on 2016/6/20.
 * 按输入的值打印二叉树的路径
 * 考察抽象问题具体化的能力
 */
public class PrintPathByValue {

    private static List<Tree> list = new ArrayList<Tree>();

    public static void printPath(Stack<Tree> path, int result, int value) {
        Tree tree = path.peek();
        if (tree != null) {
            result = result + tree.getValue();
            if (tree.getLeft() != null) {
                path.push(tree.getLeft());
                printPath(path, result, value);
            }
            if (tree.getRight() != null) {
                path.push(tree.getRight());
                printPath(path, result, value);
            }
            if (tree.getLeft() == null && tree.getRight() == null && value == result) {
                Stack<Tree> tempPath = (Stack<Tree>) path.clone();//不能直接通过tempPath =path赋值，这样只是赋了一个引用，path的pop()方法对temp也起作用
                // System.out.println("before:"+tempPath.peek().getValue());
                //list.add(path.pop());
                path.pop();
                //popBack(path,list);
                // System.out.println("after:"+tempPath.peek().getValue());
                printStack(tempPath);

            } else if (tree.getLeft() == null && tree.getRight() == null && value != result) {
                result = result - tree.getValue();
                path.pop();
//                list.add(path.pop());
//                popBack(path,list);
                //printPath(path,result,value);
            }
        }


    }

    public static void printStack(Stack<Tree> stack) {
        Stack<Tree> tempStack = new Stack<Tree>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()) {
            System.out.println(tempStack.pop().getValue());
        }
    }

    public static void popBack(Stack<Tree> stack, List<Tree> pop) {
        Tree tree = stack.peek();
        if (tree.getRight() != null && pop.contains(tree.getRight())) {
            pop.add(stack.pop());
            popBack(stack, pop);
        } else if (tree.getRight() == null && tree.getLeft() != null && pop.contains(tree.getLeft())) {
            pop.add(stack.pop());
            popBack(stack, pop);
        }
    }

    public static void main(String args[]) {
        Tree tree = new Tree();
        tree.setValue(10);
        Tree tree1 = new Tree();
        tree1.setValue(5);
        Tree tree2 = new Tree();
        tree2.setValue(4);
        Tree tree3 = new Tree();
        tree3.setValue(7);
        Tree tree4 = new Tree();
        tree4.setValue(12);
        tree.setLeft(tree1);
        tree.setRight(tree4);
        tree1.setLeft(tree2);
        tree1.setRight(tree3);
        Stack<Tree> stack = new Stack<Tree>();
        stack.push(tree);
        printPath(stack, 0, 22);
    }
}
