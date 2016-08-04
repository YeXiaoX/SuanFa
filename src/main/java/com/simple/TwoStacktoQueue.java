package com.simple;

import java.util.Stack;

/**
 * Created by Ivan on 2016/5/27.
 * 用两个栈实现队列
 * 考察对基本数据结构的理解
 */
public class TwoStacktoQueue {
    private Stack stack1;
    private Stack stack2;

    public TwoStacktoQueue(){
        this.stack1 = new Stack();
        this.stack2 = new Stack();
    }

   public void add(Object o){
       if(stack2.isEmpty()) {
           stack1.add(o);
       }else{
           while(!stack2.isEmpty()){
               stack1.add(stack2.pop());
           }
           stack1.add(0);
       }
   }

    public Object get(){
        if(!stack1.isEmpty()&&stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }else if(stack1.isEmpty()&&!stack2.isEmpty()){
            return stack2.pop();
        }else {
            return null;
        }
    }

    public void delete(){
        if(stack1.isEmpty()&&!stack2.isEmpty()){
            stack2.pop();
        }else if(stack2.isEmpty()&&!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.add(stack2.pop());
            }
            stack2.pop();
        }
    }

    public static void main(String args[]){

        TwoStacktoQueue tw = new TwoStacktoQueue();
        tw.add(1);
        tw.add(2);
        tw.add(3);
        System.out.println("获取队列头的元素："+tw.get());
        tw.delete();
        tw.delete();
        tw.delete();
        System.out.println("获取删除后队列头的元素:"+tw.get());
    }

}
