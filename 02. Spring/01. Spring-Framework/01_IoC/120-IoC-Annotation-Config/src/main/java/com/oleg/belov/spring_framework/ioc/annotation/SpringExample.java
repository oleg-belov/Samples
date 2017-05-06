package com.oleg.belov.spring_framework.ioc.annotation;

import static com.oleg.belov.spring_framework.ioc.annotation.utils.ClassNameUtil.getCurrentClassName;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.ioc.annotation.beans.SimpleBean1;
import com.oleg.belov.spring_framework.ioc.annotation.beans.SimpleBean2;
import com.oleg.belov.spring_framework.ioc.annotation.beans.SimpleInterface;
import com.oleg.belov.spring_framework.ioc.annotation.config.ApplicationConfig;

public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	public static void main(String[] args) {
		SpringExample se = new SpringExample();
		se.demoSpring();
	}

	public void demoSpring() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		SimpleBean1 sb1 = ctx.getBean(SimpleBean1.class);
		sb1.methodForFirst();

		SimpleBean2 sb2 = ctx.getBean(SimpleBean2.class);
		sb2.methodForSecond();

		SimpleInterface si1 = ctx.getBean(SimpleInterface.class);
		si1.sayHello();

		DataSource dataSource = (DataSource) ctx.getBean("datasourse");
		log.info("dataSource = " + dataSource);
	}
}
