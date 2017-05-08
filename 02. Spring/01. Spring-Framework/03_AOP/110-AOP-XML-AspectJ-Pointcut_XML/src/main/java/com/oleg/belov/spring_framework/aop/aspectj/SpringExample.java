package com.oleg.belov.spring_framework.aop.aspectj;

import static com.oleg.belov.spring_framework.aop.aspectj.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.aop.aspectj.bean.CityManager;
import com.oleg.belov.spring_framework.aop.aspectj.bean.RegionManager;

public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "springExample.xml" });

		// pointcut1(context);

		// pointcut2(context);

		pointcut3(context);

	}

	private static void pointcut1(ApplicationContext context) {
		RegionManager regionManager = (RegionManager) context.getBean("regionManager");
		log.info("===============================================");
		log.info("" + regionManager.getNumber());
		log.info("" + regionManager.getName());
		log.info("" + regionManager.getClass());
		log.info("" + "===============================================");
		regionManager.createRegion("SPB");
	}

	private static void pointcut2(ApplicationContext context) {
		CityManager cityManager = (CityManager) context.getBean("cityManager");
		cityManager.deleteCity();
		cityManager.getNumber();
		cityManager.getName();
		cityManager.createCity("test");

	}

	private static void pointcut3(ApplicationContext context) {
		RegionManager regionManager = (RegionManager) context.getBean("regionManager");
		log.info("" + regionManager.getNumber());
		log.info("" + regionManager.getName());
		log.info("" + regionManager.getClass());
		regionManager.createRegion("SPB");
	}

}
