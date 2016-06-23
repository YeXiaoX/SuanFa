package com.simple;

import java.util.List;

/**
 * Created by Ivan on 2016/6/22.
 * 把二叉搜索树转变为排序的双向链表
 * 考察复杂问题简化的能力
 */
public class ChangeTreeToLink {
    public  static void change(Tree root,Tree front,Tree next){
        if(root==null)return ;
        if(root!=null){
            change(root.getLeft(),root.getLeft()!=null?root.getLeft().getLeft():null,root);
            if(root.getLeft()==null) {
                root.setLeft(front);
            }
            if(root.getRight()==null) {
                root.setRight(next);
            }
            change(root.getRight(),root,root.getRight()!=null?root.getRight().getLeft():null);
        }
    }

    public static void change1(Tree root){
        Tree last = new Tree();
        if(root==null)return;
        if(root!=null){
            change1(root.getLeft());
            last = root;
            change1(root.getRight());
        }
    }

    public static void convertTree(Tree root,Tree last){

    }
}
