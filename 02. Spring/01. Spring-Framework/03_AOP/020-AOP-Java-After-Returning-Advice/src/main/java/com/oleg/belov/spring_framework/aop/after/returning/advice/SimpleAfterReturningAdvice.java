package com.oleg.belov.spring_framework.aop.after.returning.advice;

import static com.oleg.belov.spring_framework.aop.after.returning.advice.utils.ClassNameUtil.getCurrentClassName;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(target);

        MessageWriter proxy = (MessageWriter) pf.getProxy();
        proxy.writeMessage();
    }

    public void afterReturning(Object returnValue, Method method, 
             Object[] args, Object target) throws Throwable {
        log.info("");
        log.info("After method: " + method.getName());
    }
}
