package com.oleg.belov.spring_framework.aop.adviser.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import static com.oleg.belov.spring_framework.aop.adviser.utils.ClassNameUtil.getCurrentClassName;

import java.lang.reflect.Method;

public class BeforeMethod implements MethodBeforeAdvice {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("Before Method!");
    }

}

