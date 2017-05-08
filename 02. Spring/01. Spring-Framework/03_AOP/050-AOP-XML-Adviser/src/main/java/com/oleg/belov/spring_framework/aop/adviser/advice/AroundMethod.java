package com.oleg.belov.spring_framework.aop.adviser.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oleg.belov.spring_framework.aop.adviser.utils.ClassNameUtil.getCurrentClassName;

import java.util.Arrays;

public class AroundMethod implements MethodInterceptor {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

       log.info("Method name : " + methodInvocation.getMethod().getName());
       log.info("Method arguments : " + Arrays.toString(methodInvocation.getArguments()));

        // до метода
       log.info("AroundMethod : Вместо BeforeMethod!");

        try {
            // выполняем оригинальный метод
            Object result = methodInvocation.proceed();
            // после метода
           log.info("AroundMethod : Вместо AfterMethod!");
            return result;
        } catch (IllegalArgumentException e) {
            // если был выброс исключения
           log.info("AroundMethod : Вместо ThrowMethod!");
            throw e;
        }

    }
}
