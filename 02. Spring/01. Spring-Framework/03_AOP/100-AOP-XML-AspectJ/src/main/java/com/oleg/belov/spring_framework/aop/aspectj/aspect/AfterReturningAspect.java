package com.oleg.belov.spring_framework.aop.aspectj.aspect;

import static com.oleg.belov.spring_framework.aop.aspectj.utils.ClassNameUtil.getCurrentClassName;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AfterReturningAspect {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	@AfterReturning(pointcut = "execution(* com.oleg.belov.spring_framework.aop.aspectj.bean.RegionManager.getNumber(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		log.info("logAfterReturning() is running!");
		log.info("перехват : " + joinPoint.getSignature().getName());
		log.info("Method returned value is : " + result);
		log.info("******");

	}

}
