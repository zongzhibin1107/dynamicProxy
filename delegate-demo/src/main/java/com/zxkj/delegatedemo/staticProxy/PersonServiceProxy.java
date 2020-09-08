package com.zxkj.delegatedemo.staticProxy;

/**
 * 代理类
 * 通过构造函数传入目标类和增强类
 */
public class PersonServiceProxy implements PersonService {
    /**
     * 目标类
     */
    private PersonService personService;

    /**
     * 增强类
     */
    private Transcation transcation;


    public PersonServiceProxy(PersonService personService,Transcation transaction){
        this.personService = personService;
        this.transcation = transaction;
    }

    @Override
    public void savePerson() {
        transcation.beginTranscation();
        personService.savePerson();
        transcation.commit();
    }

    @Override
    public void updatePerson() {
        transcation.beginTranscation();
        personService.updatePerson();
        transcation.commit();
    }

    @Override
    public void deletePerson() {
        transcation.beginTranscation();
        personService.deletePerson();
        transcation.commit();
    }
}
