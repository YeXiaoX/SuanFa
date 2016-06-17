package com.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ivan on 2016/6/17.
 * 从上到下打印二叉树
 * 抽象问题具体化
 */
public class ToptoDownPrintTree {
    public  static void printTree(Queue<Tree>queue){
        if(!queue.isEmpty()){
            Tree temp = queue.poll();
            try {
                System.out.println(temp.getValue());
           queue.offer(temp.getLeft());
            queue.offer(temp.getRight());
            printTree(queue);
            printTree(queue);
            }catch (Exception e){
                //e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        Tree tree = new Tree();
        tree.setValue(8);
        Tree tree1 = new Tree();
        tree1.setValue(6);
        Tree tree2 = new Tree();
        tree2.setValue(10);
        Tree tree3 = new Tree();
        tree3.setValue(5);
        Tree tree4 = new Tree();
        tree4.setValue(7);
        Tree tree5 = new Tree();
        tree5.setValue(9);
        Tree tree6 = new Tree();
        tree6.setValue(11);
        tree.setLeft(tree1);
        tree.setRight(tree2);
        tree1.setLeft(tree3);
        tree1.setRight(tree4);
        tree2.setLeft(tree5);
        tree2.setRight(tree6);
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(tree);
        printTree(queue);
    }
}
