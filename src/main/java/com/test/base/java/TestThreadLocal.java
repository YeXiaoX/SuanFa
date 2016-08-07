package com.test.base.java;

/**
 * Created by Ivan on 2016/8/7.
 * 一个静态变量定义为threadlocal和不定义为threadlocal在多线程下的区别
 * 如果是threadlocal，则在多线程下当在单个线程下改变变量的值时，不影响其他线程
 * 非threadlocal时，单个线程改变变量时可能会影响其他线程的值
 */
public class TestThreadLocal {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private static Integer noThreadLocal = null;
    public static Integer getInteger(){
        if(threadLocal.get()==null) {
            threadLocal.set(1);

        }
        return  threadLocal.get();
    }
    public static void setInteger(Integer a){
        threadLocal.set(a);
    }

    public static Integer getNoThreadLocal() {
        if(noThreadLocal == null){
            noThreadLocal = 2;
        }
        return noThreadLocal;
    }

    public static void setNoThreadLocal(Integer noThreadLocal) {
        TestThreadLocal.noThreadLocal = noThreadLocal;
    }
}
