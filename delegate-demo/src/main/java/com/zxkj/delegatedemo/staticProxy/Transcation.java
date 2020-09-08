package com.zxkj.delegatedemo.staticProxy;

public class Transcation {

    public void beginTranscation(){
        System.out.println("开启事务");
    }

    public void commit(){
        System.out.println("提交事务");
    }
}
