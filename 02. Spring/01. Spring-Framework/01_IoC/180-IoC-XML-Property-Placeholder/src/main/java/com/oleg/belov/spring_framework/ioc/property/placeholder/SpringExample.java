package com.oleg.belov.spring_framework.ioc.property.placeholder;

import static com.oleg.belov.spring_framework.ioc.property.placeholder.utils.ClassNameUtil.getCurrentClassName;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }

    public void demoSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        DataSource dataSource = (DataSource) context.getBean("dataSource");
        log.info("dataSource = " + dataSource);

        PropertiesBean propertiesBean = (PropertiesBean) context.getBean("propertyBean");
        log.info("propertiesBean = " + propertiesBean);


    }
}
