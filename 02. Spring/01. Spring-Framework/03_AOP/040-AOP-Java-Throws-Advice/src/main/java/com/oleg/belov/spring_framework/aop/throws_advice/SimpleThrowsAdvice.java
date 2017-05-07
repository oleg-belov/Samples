package com.oleg.belov.spring_framework.aop.throws_advice;

import static com.oleg.belov.spring_framework.aop.throws_advice.utils.ClassNameUtil.getCurrentClassName;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleThrowsAdvice implements ThrowsAdvice {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public static void main(String[] args) throws Exception {
        ErrorBean errorBean = new ErrorBean();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(errorBean);
        pf.addAdvice(new SimpleThrowsAdvice());

        ErrorBean proxy = (ErrorBean) pf.getProxy();

        try {
            proxy.errorProneMethod();
        } catch (Exception ignored) {

        }

        try {
            proxy.otherErrorProneMethod();
        } catch (Exception ignored) {

        }
    }

    public void afterThrowing(Exception ex) throws Throwable {
        log.info("***");
        log.info("Generic Exception Capture");
        log.info("Caught: " + ex.getClass().getName());
        log.info("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target,
            IllegalArgumentException ex) throws Throwable {
        log.info("***");
        log.info("IllegalArgumentException Capture");
        log.info("Caught: " + ex.getClass().getName());
        log.info("Method: " + method.getName());
        log.info("***\n");
    }
}
