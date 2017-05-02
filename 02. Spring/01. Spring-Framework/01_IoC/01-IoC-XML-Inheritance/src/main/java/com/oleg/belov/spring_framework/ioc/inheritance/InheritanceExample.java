package com.oleg.belov.spring_framework.ioc.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.ioc.inheritance.beans.Child;

import static com.oleg.belov.spring_framework.ioc.inheritance.utils.ClassNameUtil.getCurrentClassName;

public class InheritanceExample {

    private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        log.debug("\n\n\n");

        final Child child = context.getBean("child", Child.class);
        log.debug("Child name: {}", child.getName());
        log.debug("Child responsible's Passport Number: {}", child.getResponsible().getPaspNum());
    }

}
