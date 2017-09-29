package com.oleg.belov.spring.data.jpa;

import static com.oleg.belov.spring.data.jpa.utils.ClassNameUtil.getCurrentClassName;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;
import com.oleg.belov.spring.data.jpa.service.BookStoreService;

@Component
public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	private static  BookStoreService bookStoreService;
	private final static String CATEGORY_NAME = "Swing";
	private final static Long CATEGORY_ID_GREATER_THAN = 5L;
	private final static Long CATEGORY_ID_GREATER_THAN_EQUAL = 5L;
	private final static Long CATEGORY_ID_LESS_THAN_EQUAL = 5L;
	private final static int PAGEABLE_PAGE = 1;
	private final static int PAGEABLE_SIZE = 2;
	
	
	@SuppressWarnings("static-access")
	@Autowired
	public SpringExample(BookStoreService bookStoreService) {
		this.bookStoreService = bookStoreService;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings({ "resource", "unused" })
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
		
		findByCategoryIdGreaterThanSort(CATEGORY_ID_GREATER_THAN, new Sort(Sort.Direction.DESC, "categoryId"));
		log.info("\n");
		findByCategoryIds(1L, 5L, 7L, 10L);
	}

	private static void findByCategoryIdGreaterThanSort(Long categoryIdGreaterThan, Sort sort) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdGreaterThan(categoryIdGreaterThan, sort);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}

	private static void findByCategoryIds(Long firstId, Long secondId, Long thirdId, Long fourthId) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIds(Arrays.asList(firstId, secondId, thirdId, fourthId));
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
}
