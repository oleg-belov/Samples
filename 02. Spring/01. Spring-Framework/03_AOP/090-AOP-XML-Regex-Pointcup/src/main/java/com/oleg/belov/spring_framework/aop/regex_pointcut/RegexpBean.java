package com.oleg.belov.spring_framework.aop.regex_pointcut;

import static com.oleg.belov.spring_framework.aop.regex_pointcut.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegexpBean {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public void foo1() {
        log.info("foo1");
    }

    public void foo2() {
        log.info("foo2");
    }

    public void bar() {
        log.info("bar");
    }
}
