package com.zxkj.delegatedemo.dynamicProxy.springAop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        String xmlPath = "applicationContext.xml";
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(xmlPath);


        PersonService proxyPersonService = (PersonService)context.getBean("personService");
        String returnValue = proxyPersonService.savePerson();
        System.out.println(returnValue);

    }
}
