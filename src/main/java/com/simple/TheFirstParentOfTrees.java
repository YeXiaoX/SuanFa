package com.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ivan on 2016/7/21.
 * 两个节点的最低的父亲节点（普通的二叉树篇）
 */
public class TheFirstParentOfTrees {
    public static List<Tree> getAllPaths(Tree head, List<Tree> list) {
        if (head != null) {
            list.add(head);
            list = getAllPaths(head.getLeft(), list);
            list = getAllPaths(head.getRight(), list);
        }
        return list;
    }

    public static List<Tree> getPaths(Tree head, List<Tree> list) {
        Tree temp = head;
        for (int i = list.size() - 1; i >= 0; i--) {
            Tree tree = list.get(i);
            if (tree.getLeft() == temp || tree.getRight() == temp) {
                temp = tree;
            } else if (tree != head) {
                list.remove(list.get(i));
            }
        }
        return list;
    }

    public static Tree getFirstCross(List<Tree> list1, List<Tree> list2) {
        Tree result = null;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return result;
            result = list1.get(i);
        }
        return result;
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
        List<Tree> list = new ArrayList<Tree>();
        getAllPaths(tree, list);
        getPaths(tree3, list);
//        for (Tree treeTemp : list) {
//            System.out.println(treeTemp.getValue());
//        }
        List<Tree> list1 = new ArrayList<Tree>();
        getAllPaths(tree, list1);
        getPaths(tree4, list1);
//        for (Tree treeTemp : list1) {
//            System.out.println(treeTemp.getValue());
//        }
        Tree treeResult = getFirstCross(list, list1);
        System.out.println(treeResult.getValue());
    }
}
