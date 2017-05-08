package com.oleg.belov.spring_framework.aop.aspectj.aspect;

import static com.oleg.belov.spring_framework.aop.aspectj.utils.ClassNameUtil.getCurrentClassName;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class BeforeAspect {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	/*
	 * В скобочках аннотации указывается pointcut(срез), с помощью которого
	 * определяется метод который будет перехвачен методом logBefore().
	 */

	@Before("execution(* com.oleg.belov.spring_framework.aop.aspectj.bean.RegionManager.createRegion(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info("logBefore() is running!");
		log.info("перехват : " + joinPoint.getSignature().getName());
		log.info("******");
	}

}
