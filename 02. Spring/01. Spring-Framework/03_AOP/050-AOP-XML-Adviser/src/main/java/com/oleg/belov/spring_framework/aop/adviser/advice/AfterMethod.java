package com.oleg.belov.spring_framework.aop.adviser.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;

import static com.oleg.belov.spring_framework.aop.adviser.utils.ClassNameUtil.getCurrentClassName;

import java.lang.reflect.Method;

public class AfterMethod implements AfterReturningAdvice {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        log.info("AfterMethod!");
    }

}

