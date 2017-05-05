package com.oleg.belov.spring_framework.ioc.method.injection;

import static com.oleg.belov.spring_framework.ioc.method.injection.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.ioc.method.injection.bean.Command;
import com.oleg.belov.spring_framework.ioc.method.injection.bean.CommandManager;

public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }

    public void demoSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        CommandManager cm = context.getBean("commandManager", CommandManager.class);

        log.info("class: " + cm.getClass().getCanonicalName());

        Command c1 = cm.createCommand();
        log.info("Hash C1:" + c1.hashCode());
        c1.execute();

        Command c2 = cm.createCommand();
        log.info("Hash C2:" + c2.hashCode());
        log.info("State C2:" + c2.getState());
    }
}
