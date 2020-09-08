package com.zxkj.delegatedemo.dynamicProxy.cglibProxy;

public class MainClass {

    public static void main(String[] args) {
        Object target = new PersonServiceImpl();
        MyTransaction myTransaction = new MyTransaction();
        PersonServiceInterceptor interceptor = new PersonServiceInterceptor(target, myTransaction);

        PersonService personService = (PersonService)interceptor.createProxy();
        String returnValue = personService.savePerson();
        System.out.println(returnValue);
    }
}
