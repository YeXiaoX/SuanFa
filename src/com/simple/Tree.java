package com.simple;

/**
 * Created by Ivan on 2016/5/26.
 * 树结构
 */
public class Tree {
    private Tree right;
    private Tree left;
    private int value;


    public Tree(){
        super();
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
