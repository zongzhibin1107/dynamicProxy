package com.zxkj.delegatedemo.dynamicProxy.jdkProxy;

import java.lang.reflect.Proxy;

public class MainClass {

    /**
     * 1、当客户端执行代理对象.方法时，进入到了拦截器的invoke方法体
     * 2、拦截器中invoke方法体的内容就是代理对象方法体的内容
     * 3、拦截器中invoke方法的method参数是在调用的时候赋值的
     * @param args
     */
    public static void main(String[] args) {
        Object target = new PersonServiceImpl();
        MyTransaction myTransaction = new MyTransaction();
        PersonServiceInterceptor interceptor = new PersonServiceInterceptor(target, myTransaction);
        System.out.println(target.getClass().getClassLoader());
        System.out.println( target.getClass().getInterfaces());
        Class<?>[] interfaces = target.getClass().getInterfaces();
        PersonService personService =
                (PersonService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);
        String s = personService.savePerson();
        System.out.println(s);
    }
}
