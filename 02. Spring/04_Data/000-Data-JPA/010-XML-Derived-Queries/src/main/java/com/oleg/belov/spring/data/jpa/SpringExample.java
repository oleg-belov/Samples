package com.oleg.belov.spring.data.jpa;

import static com.oleg.belov.spring.data.jpa.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.oleg.belov.spring.data.jpa.service.BookStoreService;

@Component
public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	private static BookStoreService bookStoreService;
	
	@SuppressWarnings("static-access")
	@Autowired
	public SpringExample(BookStoreService bookStoreService) {
		this.bookStoreService = bookStoreService;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
	}
}
