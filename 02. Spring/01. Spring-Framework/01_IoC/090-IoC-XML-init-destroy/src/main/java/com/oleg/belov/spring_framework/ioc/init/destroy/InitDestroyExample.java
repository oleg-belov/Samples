package com.oleg.belov.spring_framework.ioc.init.destroy;

import static com.oleg.belov.spring_framework.ioc.init.destroy.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDestroyExample {

	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        log.debug("\n\n\n");

        Thread.sleep(5000);

        log.debug("Destroying context...");
        context.destroy();
    }

}
