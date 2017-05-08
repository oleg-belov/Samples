package com.oleg.belov.spring_framework.aop.aspectj;

import static com.oleg.belov.spring_framework.aop.aspectj.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.aop.aspectj.bean.RegionManager;

public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

		// beforeAspect(context);

		// afterAspect(context);

		// afterReturnAspect(context);

		// afterThrowAspect(context);

		aroundAspect(context);
	}

	private static void beforeAspect(ApplicationContext context) {
		RegionManager regionManager = (RegionManager) context.getBean("regionManager");
		log.info("===============================================");
		log.info("" + regionManager.getNumber());
		log.info("===============================================");
		regionManager.createRegion("SPB");
	}

	private static void afterAspect(ApplicationContext context) {
		RegionManager regionManager = (RegionManager) context.getBean("regionManager");
		log.info("===============================================");
		log.info("" + regionManager.getNumber());
		log.info("===============================================");
		regionManager.createRegion("SPB");
	}

	private static void afterReturnAspect(ApplicationContext context) {
		RegionManager regionManager = (RegionManager) context.getBean("regionManager");
		log.info("===============================================");
		log.info("" + regionManager.getNumber());
		log.info("===============================================");
		regionManager.createRegion("SPB");
	}

	private static void afterThrowAspect(ApplicationContext context) {
		RegionManager regionManager = (RegionManager) context.getBean("regionManager");
		log.info("===============================================");
		log.info("" + regionManager.getNumber());
		log.info("===============================================");
		regionManager.createRegion(null);
	}

	private static void aroundAspect(ApplicationContext context) {
		RegionManager regionManager = (RegionManager) context.getBean("regionManager");
		log.info("===============================================");
		log.info("" + regionManager.getNumber());
		log.info("===============================================");
		regionManager.createRegion("SPB");
	}

}
