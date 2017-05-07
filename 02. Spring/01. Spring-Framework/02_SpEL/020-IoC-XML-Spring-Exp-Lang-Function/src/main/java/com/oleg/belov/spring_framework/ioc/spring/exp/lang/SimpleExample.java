package com.oleg.belov.spring_framework.ioc.spring.exp.lang;

import static com.oleg.belov.spring_framework.ioc.spring.exp.lang.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.ioc.spring.exp.lang.bean.Customer;

public class SimpleExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public static void main(String[] args) throws NoSuchMethodException {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
        Customer customer = ctx.getBean(Customer.class);
        log.info("customer = " + customer);


    }


}
