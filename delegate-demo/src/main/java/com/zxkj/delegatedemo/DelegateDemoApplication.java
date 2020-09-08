package com.zxkj.delegatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DelegateDemoApplication {

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(DelegateDemoApplication.class, args);
    }

}
