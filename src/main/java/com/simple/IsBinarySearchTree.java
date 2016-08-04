package com.simple;

/**
 * Created by Ivan on 2016/6/18.
 * 判断一个后序遍历的数组是否是一个二叉搜索树的后序遍历结果
 * 考察抽象问题具体化的能力
 */
public class IsBinarySearchTree {
    public static boolean isSearchTree(int order[],int start,int end){
  if(end<0||start<0||start>end)return false;
        if(start==end)return true;
        if(order[start]>order[end]){
            for(int i=start;i<end;i++){
                if(order[i]<order[end])return false;
            }
             isSearchTree(order,start,--end);
            //isSearchTree(order,start,end--);//这种写法会导致栈内存溢出，因为每次执行时end的值不变
        }else if(order[end-1]<order[end]){
            for(int i=start;i<end;i++){
                if(order[i]>order[end])return false;
            }
             isSearchTree(order,start,--end);
        }else{
            int i=start;
           while(order[i]<order[end]){
               i++;
           }
            return isSearchTree(order,start,i-1)&&isSearchTree(order,i,end-1);

        }
        return true;
    }

    public static void main(String args[]){
        int test[]={23,1,2};//{5,7,6,9,10,11,8};
        System.out.println("result:"+isSearchTree(test,0,test.length-1));
    }
}
