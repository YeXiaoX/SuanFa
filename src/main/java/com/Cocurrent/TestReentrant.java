package com.Cocurrent;

/**
 * Created by Ivan on 2016/8/8.
 * 重入
 * 假设现在有一个父类Father,它里面的变量需要占用1M内存.有一个它的子类Son,它里面的变量需要占用0.5M内存.
 现在通过代码来看看内存的分配情况
 Father f=new Father()；//系统将分配1M内存.
 Son s=new Son()；//系统将分配1.5M内存，因为子类中有一个隐藏的引
 用super会指向父类实例,所以在实例化子类之前会先实例化一个父类,也就是说会先执行父类的构造函数.由于s中包含了父类的实例,所以s可以调用父类
 的方法.
 Son s1=s；/s1指向那1.5M的内存.
 Father f1=(Father)s；/这时f1会指向那1.5M内存中的1M内存,即是说,f1只是指向了s中实例的父类实例对象,所以f1只能调用父类的方法(存储
 在1M内存中),而不能调用子类的方法(存储在0.5M内存中).

 * java中一个类的方法区是所有对象共有的，所以针对方法的锁也就是针对对象的，多个线程通过同一个对象调用方法时，需要先获得方法上的锁。
 * 子类的dosomething执行前都会先获取父类上的锁，所以如果synchronized不是可重入的锁，则此时将产生死锁
 */
public class TestReentrant extends Reentrant{
    public TestReentrant(int i){
        System.out.println("son ");
    }
    public synchronized void doSomething(Thread thread,long c){
//        try {
//            System.out.println("son sleep "+c);
//            thread.sleep(c);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        super.doSomething(thread,c);
        System.out.println("son do something");
    }

    public static void main(String args[]){
        //final Reentrant r = new Reentrant();
        Thread thread0 = new Thread(){
            @Override
            public void run() {
                TestReentrant tr = new TestReentrant(1);
                tr.doSomething(this,8000);
            }
        };
        thread0.start();

//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                r.doSomething(this,5000);
//            }
//        };
//        thread.start();
//
//        Thread thread2 = new Thread(){
//            @Override
//            public void run() {
//               // Reentrant r = new Reentrant();
//                r.doSomething(this,2000);
//            }
//        };
//        thread2.start();
    }
}
