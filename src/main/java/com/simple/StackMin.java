package com.simple;

import java.util.Stack;

/**
 * Created by Ivan on 2016/6/15.
 * 包含min函数的栈，在O(1)时间内找到一个栈中最小的元素，即在O(1)时间执行pop(),push(),min()
 * 考察抽象问题具体化，举例模拟的能力
 */
public class StackMin {
    private Stack main;
    private Stack vce;

    public StackMin(Stack main,Stack vce){
        this.main = main;
        this.vce = vce;
    }

    public Object pop(){
        if(main.isEmpty())return null;
        vce.pop();
        return main.pop();
    }

    public void push(Object o){
        main.push(o);
        if(vce.isEmpty()){
            vce.push(o);
        }else{
            Integer min = (Integer)vce.peek();
            if(min>=(Integer)o){
                vce.push(o);
            }else{
                vce.push(min);
            }
        }
    }
    public Object min(){
        if(vce.isEmpty())return null;
        Integer min = (Integer)vce.peek();
        return min;
    }

    public static void main(String args[]){
        Stack main = new Stack();
        Stack vce = new Stack();
        StackMin min = new StackMin(main,vce);
        min.push(new Integer(3));
        min.push(new Integer(4));
        min.push(new Integer(2));
        min.push(new Integer(1));
        System.out.println(min.min());
        System.out.println(min.pop());
        System.out.println(min.min());

    }
}
