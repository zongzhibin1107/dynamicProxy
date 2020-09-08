package com.zxkj.delegatedemo.dynamicProxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class PersonServiceInterceptor implements MethodInterceptor {

    /**
     * 目标类
     */
    private Object target;

    /**
     * 增强类
     */
    private MyTransaction myTransaction;


    /**
     * 通过构造函数传入目标类和增强类
     * @param target
     * @param myTransaction
     */
    public PersonServiceInterceptor(Object target, MyTransaction myTransaction) {
        this.target = target;
        this.myTransaction = myTransaction;
    }


    /**
     * 创建代理对象   其实就是目标类的子类
     * @return
     */
    public Object createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(this.target.getClass());
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        myTransaction.beginTransaction();
        Object returnValue = method.invoke(this.target, objects);
        myTransaction.commit();
        return returnValue;
    }
}
