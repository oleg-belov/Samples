package com.oleg.belov.spring_framework.aop.advice;

import static com.oleg.belov.spring_framework.aop.advice.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.aop.advice.bean.RegionManager;

public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});


        RegionManager regionManager = (RegionManager) context.getBean("regionProxy");
        log.info("" + regionManager.getNumber());


        //regionManager.throwException();

        regionManager.getInfo();


    }
}
