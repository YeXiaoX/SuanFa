package com.simple;

/**
 * Created by Ivan on 2016/7/7.
 * 二叉树的深度
 * 知识迁移能力
 * 类似题：判断一个二叉树是否是平衡二叉树，左右子树深度相减差是否大于1
 */
public class TheDeepthOfTree {
    public static int getNumber(Tree root, int length) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                length++;
            } else {
                int left = getNumber(root.getLeft(), length);
                int right = getNumber(root.getRight(), length);
                length = right;
                if (left > right) length = left;
                length = length + 1;
            }
        }
        return length;
    }

    public static void main(String args[]) {
        Tree root = new Tree();
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        Tree tree3 = new Tree();
        Tree tree4 = new Tree();
        Tree tree5 = new Tree();
        Tree tree6 = new Tree();
        Tree tree7 = new Tree();
        root.setValue(1);
        tree1.setValue(2);
        tree2.setValue(3);
        tree3.setValue(4);
        tree4.setValue(5);
        tree5.setValue(6);
        tree6.setValue(7);
        tree7.setValue(8);
        root.setLeft(tree1);
        root.setRight(tree2);
        tree1.setLeft(tree3);
        tree3.setLeft(tree4);
        //tree1.setRight(tree4);
        tree2.setLeft(tree5);
        tree2.setRight(tree6);
        tree5.setLeft(tree7);
        System.out.println(getNumber(tree4.getLeft(), 0));
    }
}
