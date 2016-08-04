package com.test.base.java;

/**
 * Created by Ivan on 2016/7/22.
 */
public class StaticMethodOverrideTest {

        public static void main(String[] args)
        {
            Annimal a = new Annimal();
            Annimal d = new Dog();//new Dog()是实例化一个dog对象，静态方法不需要实例化，所以它会直接调用Annimal的静态方法
           // Dog d = new Dog();//输出为WOWOW
            a.p();
            d.p();
          /*
          * 总结
          * JAVA静态方法形式上可以重写，但从本质上来说不是JAVA的重写。因为静态方法只与类相关，
          * 不与具体实现相关，声明的是什么类，则引用相应类的静态方法(本来静态无需声明，可以直接引用)
          * */
        }
    }

    class Annimal {
        static void p() {
            System.out.println("wow");
        }
    }

    class Dog extends Annimal {
        static void p() {
            System.out.println("WOWOW");
        }
    }


