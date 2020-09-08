package com.zxkj.delegatedemo.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 拦截器
 */
public class PersonServiceInterceptor implements InvocationHandler {

    /**
     * 目标类
     */
    private Object target;

    /**
     * 增强类
     */
    private MyTransaction myTransaction;

    /**
     * 构造函数传入对应的目标类和增强类
     * @param target
     * @param myTransaction
     */
    public PersonServiceInterceptor(Object target, MyTransaction myTransaction) {
        this.target = target;
        this.myTransaction = myTransaction;
    }


    /**
     * 代理类的每一个方法被调用的时候都会调用下边的这个invoke方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.myTransaction.beginTransaction();
        Object returnValue = method.invoke(this.target, args);
        this.myTransaction.commit();
        return returnValue;
    }
}
