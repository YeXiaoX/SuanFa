package com.test;

/**
 * Created by Ivan on 2016/7/30.
 * 考查静态语句块、构造语句块（就是只有大括号的那块）以及构造函数的执行顺序。 
 * 对象的初始化顺序：（1）类加载之后，按从上到下（从父类到子类）执行被static修饰的语句；
 * （2）当static语句执行完之后,再执行main方法；
 * （3）如果有语句new了自身的对象，将从上到下执行构造代码块、构造器（两者可以说绑定在一起）。
 */
public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("hello b");
    }


    {
        System.out.println("I AM B CLASS");
    }

    static {
        System.out.println("STATIC B");
    }

    public void test(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        new HelloB();
    }
}