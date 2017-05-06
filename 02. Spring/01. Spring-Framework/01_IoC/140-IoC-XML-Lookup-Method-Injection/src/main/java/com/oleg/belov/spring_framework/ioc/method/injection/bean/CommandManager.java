package com.oleg.belov.spring_framework.ioc.method.injection.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

abstract public class CommandManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    abstract public Command createCommand();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}