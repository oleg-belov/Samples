package com.oleg.belov.spring.data.jpa;

import static com.oleg.belov.spring.data.jpa.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.oleg.belov.spring.data.jpa.config.DataConfiguration;
import com.oleg.belov.spring.data.jpa.entity.BookCategory;
import com.oleg.belov.spring.data.jpa.service.BookCategoryService;

@Component
public class SpringExample {
	

	public static BookCategoryService bookCategoryService;
	
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
    
	@SuppressWarnings("static-access")
	@Autowired
	public SpringExample(BookCategoryService bookCategoryService) {
		this.bookCategoryService = bookCategoryService;
	}
	
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
		@SuppressWarnings({ "resource", "unused" })
		ApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class);
		
		BookCategory bookCategory = new BookCategory();
		bookCategory.setCategoryName("Ejb");
		
		log.info("Try to save bookCategory " + bookCategory);
		bookCategoryService.save(bookCategory);
		log.info("Saved succesfully");
	}
}
