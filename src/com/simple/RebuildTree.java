package com.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 2016/5/26.
 * 重建二叉树
 * 考察思维和分析能力
 */
public class RebuildTree {
    public static void front(Tree tree){
        System.out.println(tree.getValue());
        if(tree.getLeft()!=null){
            front(tree.getLeft());
        }
        if(tree.getRight()!=null){
            front(tree.getRight());
        }
    }

    public static void center(Tree tree){
        if(tree.getLeft()!=null){
            center(tree.getLeft());
        }
        System.out.println(tree.getValue());
        if(tree.getRight()!=null){
            center(tree.getRight());
        }
    }

    public static void build(List<Integer> front,List<Integer> center,Tree tree){
        if(front.size()>0){
            Integer root = front.get(0);
            List<Integer> leftCenter = center.subList(0,center.indexOf(root));
            List<Integer> leftFront = new ArrayList<Integer>();
            for(Integer i:front){
                if(leftCenter.contains(i)){
                    leftFront.add(i);
                }
            }
            if(leftFront.size()>0){
                Tree left = new Tree();
                left.setValue(leftFront.get(0));
                tree.setLeft(left);
                build(leftFront,leftCenter,left);
            }
            List<Integer> rightCenter = center.subList(center.indexOf(root)+1,center.size());
            List<Integer> rightFront = new ArrayList<Integer>();
            for(Integer i:front){
                if(rightCenter.contains(i)){
                    rightFront.add(i);
                }
            }
            if(rightFront.size()>0){
                Tree right = new Tree();
                right.setValue(rightFront.get(0));
                tree.setRight(right);
                build(rightFront,rightCenter,right);
            }

        }
    }


    public static void main(String args[]){
//        Tree root = new Tree();
//        Tree tree1 = new Tree();
//        Tree tree2 = new Tree();
//        Tree tree3 = new Tree();
//        Tree tree4 = new Tree();
//        Tree tree5 = new Tree();
//        root.setValue(1);
//        tree1.setValue(2);
//        tree2.setValue(3);
//        tree3.setValue(4);
//        tree4.setValue(5);
//        tree5.setValue(6);
//        root.setLeft(tree1);
//        root.setRight(tree2);
//        tree1.setLeft(tree3);
//        tree2.setLeft(tree4);
//        tree2.setRight(tree5);
//        front(root);
        List<Integer> front = new ArrayList<Integer>();
        List<Integer> center = new ArrayList<Integer>();
        front.add(1);
        front.add(2);
        front.add(4);
        front.add(7);
        front.add(3);
        front.add(5);
        front.add(6);
        front.add(8);
        center.add(4);
        center.add(7);
        center.add(2);
        center.add(1);
        center.add(5);
        center.add(3);
        center.add(8);
        center.add(6);
        System.out.println(front.toString());
        String s[] = {"s","s"};
       Tree tree = new Tree();

       tree.setValue(1);
        System.out.println(s);
//        build(front,center,tree);
//        //front(tree);
//        center(tree);
    }

}
