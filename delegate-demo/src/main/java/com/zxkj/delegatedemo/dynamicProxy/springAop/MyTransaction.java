package com.zxkj.delegatedemo.dynamicProxy.springAop;

public class MyTransaction {


    public void beginTransaction(){
        System.out.println("开启事务 ");
    }
    public void commit(){
        System.out.println("提交事务");
    }
}
