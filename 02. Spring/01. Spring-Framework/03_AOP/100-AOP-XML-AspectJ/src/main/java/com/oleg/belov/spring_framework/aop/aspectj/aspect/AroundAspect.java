package com.oleg.belov.spring_framework.aop.aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oleg.belov.spring_framework.aop.aspectj.utils.ClassNameUtil.getCurrentClassName;

import java.util.Arrays;

@Aspect
public class AroundAspect {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	@Around("execution(* com.oleg.belov.spring_framework.aop.aspectj.bean.RegionManager.createRegion(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		log.info("logAround() is running!");
		log.info("перехваченный метод : " + joinPoint.getSignature().getName());
		log.info("перехваченные аргументы : " + Arrays.toString(joinPoint.getArgs()));

		log.info("Around before is running!");
		joinPoint.proceed();
		log.info("Around after is running!");

		log.info("******");

	}
}
