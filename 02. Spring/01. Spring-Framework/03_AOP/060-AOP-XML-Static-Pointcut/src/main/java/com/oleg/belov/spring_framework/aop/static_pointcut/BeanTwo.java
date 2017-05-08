package com.oleg.belov.spring_framework.aop.static_pointcut;

import static com.oleg.belov.spring_framework.aop.static_pointcut.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanTwo {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public void foo() {
        log.info("foo");
    }

    public void bar() {
        log.info("bar");
    }
}
