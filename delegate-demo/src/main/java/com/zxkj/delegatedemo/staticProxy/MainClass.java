package com.zxkj.delegatedemo.staticProxy;

public class MainClass {

    public static void main(String[] args) {

        //目标类
        PersonService personService = new PersonServiceImpl();
        //增强类
        Transcation transcation = new Transcation();
        PersonServiceProxy personServiceProxy =
                new PersonServiceProxy(personService,transcation);

        //执行代理类的方法  就是增强后的方法
        personServiceProxy.deletePerson();
        personServiceProxy.savePerson();
        personServiceProxy.updatePerson();
    }
}
