package com.simple;

/**
 * Created by Ivan on 2016/6/13.
 * 二叉树的镜像
 * 考察遇到复杂问题时的分析能力，画图解决问题的能力
 */
public class TreesMap {
    public static void changeTree(Tree root){
        if(root!=null){
            Tree temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
            changeTree(root.getLeft());
            changeTree(root.getRight());
        }

    }
    public static void printTree(Tree root){
        if(root!=null){
            System.out.println(root.getValue());
            printTree(root.getLeft());
            printTree(root.getRight());
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
       // tree.setLeft(tree1);
        tree.setRight(tree2);
        tree1.setLeft(tree3);
        tree1.setRight(tree4);
        tree2.setLeft(tree5);
        tree2.setRight(tree6);
        printTree(tree);
        changeTree(null);
        printTree(tree);

    }
}
