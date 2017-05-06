package com.oleg.belov.spring_framework.ioc.using.exclude_filter;

import static com.oleg.belov.spring_framework.ioc.using.exclude_filter.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PayrollSystem {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

		EmployeeDAO employeeDao = (EmployeeDAO) ctx.getBean("employeeDAO");
		log.info("Employee Dao: " + employeeDao);

		EmployeeService employeeService = (EmployeeService) ctx
				.getBean("employeeService");
		log.info("Employee Service: " + employeeService);

	}
}
