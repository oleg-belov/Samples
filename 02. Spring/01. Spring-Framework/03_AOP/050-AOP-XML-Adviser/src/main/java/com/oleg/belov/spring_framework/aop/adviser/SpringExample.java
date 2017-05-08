package com.oleg.belov.spring_framework.aop.adviser;

import static com.oleg.belov.spring_framework.aop.adviser.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.aop.adviser.bean.RegionManager;

public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});


        simpleAdvisor(context);

        //anotherAdvisor(context);


        //regexpAdvisor(context);


    }

    private static void regexpAdvisor(ApplicationContext context) {
        log.info("===============================================");

        RegionManager regRegionManager = (RegionManager) context.getBean("regexpRegionProxy");
        log.info("" + regRegionManager.getNumber());
        regRegionManager.getInfo();
        regRegionManager.setName("test");
        regRegionManager.setNumber(1);
        log.info("=====================================================");
    }

    private static void anotherAdvisor(ApplicationContext context) {
        log.info("===============================================");

        RegionManager newRegionManager = (RegionManager) context.getBean("newRegionProxy");
        log.info("" + newRegionManager.getNumber());
        newRegionManager.getInfo();
    }

    private static void simpleAdvisor(ApplicationContext context) {
        RegionManager regionManager = (RegionManager) context.getBean("regionProxy");

        log.info("" + regionManager.getNumber());
        regionManager.getInfo();
    }
}
