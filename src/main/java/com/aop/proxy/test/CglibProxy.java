package com.aop.proxy.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Ivan on 2016/8/4.
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer =  new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);//设置需要创建的子类
        enhancer.setCallback(this);//设置回调函数
        return  enhancer.create();//通过字节码技术动态创建子类实例
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
       PerformanceMonitor.begin(o.getClass().getName()+"."+method.getName());
        Object object = methodProxy.invokeSuper(o,objects);
        PerformanceMonitor.end();
        return object;
    }
}
