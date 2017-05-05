package com.oleg.belov.spring_framework.ioc.annotation.jsr_330;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Jsr330Example {
    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
