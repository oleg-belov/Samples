package com.oleg.belov.spring_framework.ioc.spring.exp.lang.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Person {

    @Value("#{ systemProperties['user.name'] }")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
