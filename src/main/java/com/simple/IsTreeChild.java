package com.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 2016/6/12.
 * 是否是给定二叉树的子结构
 * 考察代码的完整性和健壮性
 */
public class IsTreeChild {
    public static boolean isChild(Tree parent, Tree son) {
        if (son == null || parent == null) return false;
        List<Tree> starts = new ArrayList<Tree>();
        getTree(parent, son.getValue(), starts);
        System.out.println("size:"+starts.size());
        if (starts.size() > 0) {
            for (Tree start : starts) {
                if (compare(start, son)) return true;
            }
        }
        return false;
    }

    public static boolean compare(Tree parent, Tree son) {
        if (son != null && parent != null) {
            if (son.getValue() != parent.getValue()) {
                return false;
            }
            compare(parent.getLeft(), son.getLeft());
            compare(parent.getRight(), son.getRight());
        }
        return true;
    }

    public static void getTree(Tree parent, int value, List<Tree> list) {
        if (parent != null) {
            if (parent.getValue() == value) {
                list.add(parent);
            }
            getTree(parent.getLeft(), value, list);
            getTree(parent.getRight(), value, list);
        }
    }


    public static void main(String args[]) {
     Tree tree = new Tree();
        tree.setValue(8);
        Tree tree1 = new Tree();
        tree1.setValue(8);
        Tree tree2 = new Tree();
        tree2.setValue(7);
        Tree tree3 = new Tree();
        tree3.setValue(9);
        Tree tree4 = new Tree();
        tree4.setValue(2);
        Tree tree5 = new Tree();
        tree5.setValue(4);
        Tree tree6 = new Tree();
        tree6.setValue(7);
        tree.setLeft(tree1);
        tree.setRight(tree2);
        tree1.setLeft(tree3);
        tree1.setRight(tree4);
        tree4.setLeft(tree5);
        tree4.setRight(tree6);

        Tree son = new Tree();
        son.setValue(8);
        Tree son1 = new Tree();
        son1.setValue(9);
        Tree son2 = new Tree();
        son2.setValue(21);
        son.setLeft(son1);
        son.setRight(son2);

       boolean result = isChild(tree,null);
        System.out.println("s:"+result);

    }
}
