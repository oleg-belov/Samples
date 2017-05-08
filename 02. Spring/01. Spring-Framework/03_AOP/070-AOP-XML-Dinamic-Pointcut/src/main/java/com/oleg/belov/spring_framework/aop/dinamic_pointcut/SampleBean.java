package com.oleg.belov.spring_framework.aop.dinamic_pointcut;

import static com.oleg.belov.spring_framework.aop.dinamic_pointcut.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleBean {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public void foo(int x) {
        log.info("Invoked foo() with: " + x);
    }

    public void bar() {
        log.info("Invoked bar()");
    }
}
