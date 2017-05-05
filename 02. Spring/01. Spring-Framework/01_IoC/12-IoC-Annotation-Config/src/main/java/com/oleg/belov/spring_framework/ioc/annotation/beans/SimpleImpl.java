package com.oleg.belov.spring_framework.ioc.annotation.beans;

import static com.oleg.belov.spring_framework.ioc.annotation.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleImpl implements SimpleInterface {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    @Override
    public String sayHello() {
        final String HELLO_WORLD = "Hello, world!";
        log.info(HELLO_WORLD);
        return HELLO_WORLD;
    }

}
