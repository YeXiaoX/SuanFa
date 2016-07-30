package com.test;

/**
 * Created by Ivan on 2016/7/30.
 */
public class TestDemo{
public   static   String   output   ="";
    public   static   void   foo(int i){
        try{

        if(i==1){   
        throw  new  Exception();
        }
        }catch(Exception   e){
            output   +="2";
            return ;
        }finally{
            output   +="3";   }

        output   +="4";   }
public   static   void   main(String[]   args)   {   foo(0);   foo(1);   
        System.out.println(output);   //3423
//   Integer s;
//    System.out.println("s="+s);//开始以为会输出null什么的，运行后才发现Java中所有定义的基本类型(Integer,Double,String等）或对象都必须初始化才能输出值。
    }   }