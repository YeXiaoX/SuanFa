package com.simple;

import java.util.List;

/**
 * Created by Ivan on 2016/6/22.
 * 把二叉搜索树转变为排序的双向链表
 * 考察复杂问题简化的能力
 */
public class ChangeTreeToLink {

    public static Tree convertTree(Tree root) {
        Tree last = null;

        convertTree1(root, last);
        Tree firstLink = last;
        while (firstLink != null && firstLink.getLeft() != null) {
            firstLink = firstLink.getLeft();
        }
        return last;
    }

    public static void convertTree1(Tree root, Tree last) {
        if (root == null) return;
        Tree tree = root;

        if (tree.getLeft() != null) {
            convertTree1(tree.getLeft(), last);
        }

        tree.setLeft(last);
        if (last != null) {
            last.setRight(tree);
        }

        last = tree;
        System.out.println("first:"+last.getValue());

        if (tree.getRight() != null) {
            convertTree1(tree.getRight(), last);
        }

    }

    public static void printTree(Tree root){
        while(root!=null){
            System.out.println(root.getValue());
            root=root.getLeft();
        }
    }


    public static void main(String args[]) {
        Tree root = new Tree();
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        Tree tree3 = new Tree();
        Tree tree4 = new Tree();
        Tree tree5 = new Tree();
        Tree tree6 = new Tree();
        root.setValue(10);
        tree1.setValue(6);
        tree2.setValue(14);
        tree3.setValue(4);
        tree4.setValue(8);
        tree5.setValue(12);
        tree6.setValue(16);
        root.setLeft(tree1);
        root.setRight(tree2);
        tree1.setLeft(tree3);
        tree1.setRight(tree4);
        tree2.setLeft(tree5);
        tree2.setRight(tree6);
        Tree first = convertTree(root);
        printTree(first);


    }
}
