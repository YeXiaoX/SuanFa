package com.test;

/**
 * Created by Ivan on 2016/7/30.
 * 考察的又是父类与子类的构造函数调用次序。在Java中，子类的构造过程中必须调用其父类的构造函数，是因为有继承关系存在时，子类要把父类的内容继承下来。
 * 但如果父类有多个构造函数时，该如何选择调用呢？ 
 第一个规则：子类的构造过程中，必须调用其父类的构造方法。一个类，如果我们不写构造方法，那么编译器会帮我们加上一个默认的构造方法（就是没有参数的构造方法），但是如果你自己写了构造方法，那么编译器就不会给你添加了，
 所以有时候当你new一个子类对象的时候，肯定调用了子类的构造方法，但是如果在子类构造方法中我们并没有显示的调用基类的构造方法，如：super();  
 这样就会调用父类没有参数的构造方法。     
 第二个规则：如果子类的构造方法中既没有显示的调用基类构造方法，而基类中又没有无参的构造方法，则编译出错，所以，通常我们需要显示的：
 super(参数列表)，来调用父类有参数的构造函数，此时无参的构造函数就不会被调用。 总之，一句话：子类没有显示调用父类构造函数，不管子
 类构造函数是否带参数都默认调用父类无参的构造函数，若父类没有则编译出错。
 在本题中也调用父类的构造方法，但是在构造方法中调用的函数则是子类的，因为子类重写了父类的方法，所以在父类的构造方法中调用的是子类的方法，此时子类的变量
 那么还未被初始化，所以输出为null
 */
public class Dervied extends Base {
    private String name = "dervied";

    public Dervied() {
        tellName();
        printName();
    }

    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }

    public void printName() {
        System.out.println("Dervied print name: " + name);
    }

    public static void main(String[] args) {
        new Dervied();
    }
}