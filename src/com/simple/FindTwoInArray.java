package com.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 2016/7/11.
 * 在一个递增数组中找到n个数，使得n个数的和等于给定的数
 * 考察知识迁移能力
 */
public class FindTwoInArray {

    //在一个递增数组中找到两个数，使得两个数的和等于给定的数
    public static void getNum(int aa[],int start,int end,int n){
        if(start>end||end>aa.length-1)return;
        int i=start;
        int j=end;
        while(i<j){
            if(aa[i]+aa[j]==n){
                System.out.println(aa[i]+":"+aa[j]);
                return;
            }else if(aa[i]+aa[j]<n){
                i++;
            }else{
                j--;
                //i=start;
            }
        }
    }
    //在一个递增数组中找到连续n个数，使得n个数的和等于给定的数
    public static void getNums(int aa[],int start,int end,int n){
        if(start>end||end>aa.length-1)return;
        int i= start;
        int j=end;
        List<Integer> list=new ArrayList<Integer>();
        list.add(aa[i]);
        while(j<aa.length){
            list.add(aa[j]);
            j++;
           checkList(list,n);
        }
    }

    public static void checkList(List<Integer>list,int n){
        int result=0;
        String s="";
        for(Integer i:list){
            result+=i;
        }
        if(result==n){
            for(Integer i:list){
                s=s+i+":";
            }
            System.out.println(s);
        }else if(result>n){
            list.remove(0);
            checkList(list,n);
        }
    }
    public static void main(String args[]){
//        int aa[]={1,2,4,7,11,15};
//        getNum(aa,0,5,11);
        int a[]={1,2,3,4,5,6,7,8,14,15};
        getNums(a,0,1,15);
    }
}
