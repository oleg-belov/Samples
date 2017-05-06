package com.oleg.belov.spring_framework.ioc.environment;

import static com.oleg.belov.spring_framework.ioc.environment.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class EnvironmentSample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();

        ConfigurableEnvironment env = ctx.getEnvironment();
        
        log.debug("\n");
        log.info("user.home: " + System.getProperty("user.home"));
        log.info("JAVA_HOME: " + System.getenv("JAVA_HOME"));
        
        log.debug("\n");
        log.info("user.home: " + env.getProperty("user.home"));
        log.info("JAVA_HOME: " + env.getProperty("JAVA_HOME"));
    }
}

