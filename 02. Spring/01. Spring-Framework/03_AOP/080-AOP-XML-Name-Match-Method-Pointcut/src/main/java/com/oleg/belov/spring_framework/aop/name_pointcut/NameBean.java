package com.oleg.belov.spring_framework.aop.name_pointcut;

import static com.oleg.belov.spring_framework.aop.name_pointcut.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NameBean {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public void foo() {
        log.info("foo");
    }

    public void foo(int x) {
        log.info("foo " + x);
    }

    public void bar() {
        log.info("bar");
    }

    public void yup() {
        log.info("yup");
    }
}
