package com.oleg.belov.spring_framework.ioc.bean.inheritance;
import static com.oleg.belov.spring_framework.ioc.bean.inheritance.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

		Customer cust = (Customer) context.getBean("CustomerBean");
		log.info(cust.toString());
	}
}