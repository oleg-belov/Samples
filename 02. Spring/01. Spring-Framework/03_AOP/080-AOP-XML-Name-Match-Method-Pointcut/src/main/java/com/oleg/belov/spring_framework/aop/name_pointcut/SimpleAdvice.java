package com.oleg.belov.spring_framework.aop.name_pointcut;

import static com.oleg.belov.spring_framework.aop.name_pointcut.utils.ClassNameUtil.getCurrentClassName;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleAdvice implements MethodInterceptor {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info(">> Invoking " + invocation.getMethod().getName());
        Object retVal = invocation.proceed();
        log.info(">> Done");
        return retVal;
    }
}
