package com.oleg.belov.spring.data.jpa;

import static com.oleg.belov.spring.data.jpa.utils.ClassNameUtil.getCurrentClassName;

import java.util.ArrayList;
import java.util.List;

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
		
//		saveEntery();
//		retreivEnteties();
//		modifyingEnteties();
//		removseEnteties();
		findAllUseReadOnlyRepository();
	}

	@SuppressWarnings("unused")
	private static void saveEntery() {
		BookCategory bookCategory = new BookCategory();
		bookCategory.setCategoryName("Ejb");
		
		log.info("Try to save bookCategory " + bookCategory);
		bookCategoryService.save(bookCategory);
		log.info("Saved succesfully");		
	}

	@SuppressWarnings({ "serial", "unused" })
	private static void retreivEnteties() {
		List<BookCategory> bookCategories = bookCategoryService.findAll(new ArrayList<Long>(){{
			add(1L);
			add(3L);
			add(7L);
		}});
		log.info("Is selected:" + bookCategories.size());
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	
	@SuppressWarnings("unused")
	private static void modifyingEnteties() {
		BookCategory bookCategory = bookCategoryService.findOneById(60L);
		log.info(bookCategory.toString());
		
		bookCategory.setCategoryName("Spring Boot");
		bookCategoryService.save(bookCategory);
		
		log.info(bookCategoryService.findOneById(60L).toString() + ", is successfully modified");
	}
	
	@SuppressWarnings({ "unused", "serial" })
	private static void removeEnteties() {
		bookCategoryService.delete(60L);
		
		bookCategoryService.delete(bookCategoryService.findOneById(70L));
		
		bookCategoryService.delete(bookCategoryService.findAll(new ArrayList<Long>(){{
				add(3L);
				add(4L);
			}}));

		bookCategoryService.deleteInBatch(bookCategoryService.findAll(new ArrayList<Long>(){{
				add(5L);
				add(6L);
			}}));
		
		bookCategoryService.deleteAll();
		
		bookCategoryService.deleteAllInBatch();
	}
	
	private static void findAllUseReadOnlyRepository() {
		List<BookCategory> bookCategories = bookCategoryService.findAllUseReadOnlyRepository();
		
		log.info("Is selected:" + bookCategories.size());
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
}
