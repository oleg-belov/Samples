package com.oleg.belov.spring_framework.aop.advice.advice;

import static com.oleg.belov.spring_framework.aop.advice.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

public class ThrowException implements ThrowsAdvice {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        log.info("After Throw Exception!");
    }

}
