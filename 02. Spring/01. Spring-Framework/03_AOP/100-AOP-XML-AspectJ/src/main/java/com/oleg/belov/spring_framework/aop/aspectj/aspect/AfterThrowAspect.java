package com.oleg.belov.spring_framework.aop.aspectj.aspect;

import static com.oleg.belov.spring_framework.aop.aspectj.utils.ClassNameUtil.getCurrentClassName;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

@Aspect
public class AfterThrowAspect implements ThrowsAdvice {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    @AfterThrowing(
            pointcut = "execution(* com.oleg.belov.spring_framework.aop.aspectj.bean.RegionManager.createRegion(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        log.info("logAfterThrowing() is running!");
        log.info("перехват : " + joinPoint.getSignature().getName());
        log.info("Exception : " + error);
        log.info("******");

    }

}
