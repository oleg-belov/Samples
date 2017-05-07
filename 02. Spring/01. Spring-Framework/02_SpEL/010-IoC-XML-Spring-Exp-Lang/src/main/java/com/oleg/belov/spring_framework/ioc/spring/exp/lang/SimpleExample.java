package com.oleg.belov.spring_framework.ioc.spring.exp.lang;

import static com.oleg.belov.spring_framework.ioc.spring.exp.lang.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.ioc.spring.exp.lang.bean.User;
import com.oleg.belov.spring_framework.ioc.spring.exp.lang.bean.UserGroup;
import com.oleg.belov.spring_framework.ioc.spring.exp.lang.spel.ExpressionExample;

public class SimpleExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public static void main(String[] args) {
        SpELDemo1();
//        SpELDemo2();
    }

    private static void SpELDemo1() {
        ExpressionExample ee = new ExpressionExample();
        ee.simpleString();
        ee.concat();
        ee.upperCase();
        ee.math1();
        ee.math2();
        ee.field();
    }

    private static void SpELDemo2() throws BeansException {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        User u = ctx.getBean("userBean", User.class);
        log.info("user full name:" + u.getFirstName() + " " + u.getLastName());

        log.info("==============================================");

        UserGroup group = ctx.getBean(UserGroup.class);
        log.info("Group Name = " + group.getName());
        log.info("Group Owner = " + group.getOwner());
    }
}
