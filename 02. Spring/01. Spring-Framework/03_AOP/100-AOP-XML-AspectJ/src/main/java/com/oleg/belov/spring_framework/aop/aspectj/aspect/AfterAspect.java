package com.oleg.belov.spring_framework.aop.aspectj.aspect;

import static com.oleg.belov.spring_framework.aop.aspectj.utils.ClassNameUtil.getCurrentClassName;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AfterAspect {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    @After("execution(* com.oleg.belov.spring_framework.aop.aspectj.RegionManager.createRegion(..))")
    public void logAfter(JoinPoint joinPoint) {

        log.info("logAfter() is running!");
        log.info("перехват : " + joinPoint.getSignature().getName());
		log.info("******");

    }

}

