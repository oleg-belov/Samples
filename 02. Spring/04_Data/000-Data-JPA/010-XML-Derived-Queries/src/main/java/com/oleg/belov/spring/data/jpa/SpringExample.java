package com.oleg.belov.spring.data.jpa;

import static com.oleg.belov.spring.data.jpa.utils.ClassNameUtil.getCurrentClassName;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.oleg.belov.spring.data.jpa.service.BookStoreService;

import com.oleg.belov.spring.data.jpa.entity.BookCategory;

@Component
public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	private static  BookStoreService bookStoreService;
	private final static String CATEGORY_NAME = "Swing";
	private final static String CATEGORY_NAME_LIKE = "Swi%";
	private final static String CATEGORY_NAME_CONTAINING = "o";
	private final static String CATEGORY_NAME_STARTING_WITH = "P";
	private final static String CATEGORY_NAME_ENDING_WITH = "s";
	private final static String CATEGORY_NAME_IGNORE_CASE = "mysql";
	private final static Long CATEGORY_ID = 5L;
	private final static Long CATEGORY_ID_GREATER_THAN = 5L;
	private final static Long CATEGORY_ID_LESS_THAN = 5L;
	private final static Long CATEGORY_ID_GREATER_THAN_EQUAL = 5L;
	private final static Long CATEGORY_ID_LESS_THAN_EQUAL = 5L;
	private final static Long CATEGORY_ID_BETWEEN_MIN = 5L;
	private final static Long CATEGORY_ID_BETWEEN_MAX = 10L;
	
	
	@SuppressWarnings("static-access")
	@Autowired
	public SpringExample(BookStoreService bookStoreService) {
		this.bookStoreService = bookStoreService;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings({ "resource", "unused" })
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
		
		findByCategoryName(CATEGORY_NAME);
		log.info("\n");
		findByCategoryNameLike(CATEGORY_NAME_LIKE);
		log.info("\n");
		findByCategoryNameContaining(CATEGORY_NAME_CONTAINING);
		log.info("\n");
		findByCategoryNameStartingWith(CATEGORY_NAME_STARTING_WITH);
		log.info("\n");
		findByCategoryNameEndingWith(CATEGORY_NAME_ENDING_WITH);
		log.info("\n");
		findByCategoryNameIgnoreCase(CATEGORY_NAME_IGNORE_CASE);
		log.info("\n");
		
		findByCategoryIdEquals(CATEGORY_ID);
		log.info("\n");
		findByCategoryIdGreaterThan(CATEGORY_ID_GREATER_THAN);
		log.info("\n");
		findByCategoryIdLessThan(CATEGORY_ID_LESS_THAN);
		log.info("\n");
		findByCategoryIdGreaterThanEqual(CATEGORY_ID_GREATER_THAN_EQUAL);
		log.info("\n");
		findByCategoryIdLessThanEqual(CATEGORY_ID_LESS_THAN_EQUAL);
		log.info("\n");
		findByCategoryIdBetween(CATEGORY_ID_BETWEEN_MIN, CATEGORY_ID_BETWEEN_MAX);
		log.info("\n");
		
		findByCategoryNameContainingOrCategoryIdLessThan(CATEGORY_NAME_CONTAINING, CATEGORY_ID_LESS_THAN);
		log.info("\n");
		findByCategoryNameEndingWithAndCategoryIdLessThan(CATEGORY_NAME_ENDING_WITH, CATEGORY_ID_LESS_THAN);
		log.info("\n");
		findByCategoryIdNot(CATEGORY_ID);
		log.info("\n");
		
		findByCategoryNameContainingOrderByCategoryNameDesc(CATEGORY_NAME_CONTAINING);
		log.info("\n");
		findByCategoryIdLessThanOrderByCategoryNameAsc(CATEGORY_ID_LESS_THAN);
	}

	private static void findByCategoryName(String categoryName) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryName(categoryName);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	
	private static void findByCategoryNameLike(String categoryNameLike) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryNameLike(categoryNameLike);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	
	private static void findByCategoryNameContaining(String categoryNameContaining) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryNameContaining(categoryNameContaining);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	
	private static void findByCategoryNameStartingWith(String categoryNameStartingWith) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryNameStartingWith(categoryNameStartingWith);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	

	private static void findByCategoryNameEndingWith(String categoryNameEndingWith) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryNameEndingWith(categoryNameEndingWith);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
		
	}
	
	private static void findByCategoryNameIgnoreCase(String categoryNameIgnoreCase) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryNameIgnoreCase(categoryNameIgnoreCase);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
		
	}
	
	private static void findByCategoryIdEquals(Long categoryId) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdEquals(categoryId);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	
	private static void findByCategoryIdGreaterThan(Long categoryIdGreaterThan) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdGreaterThan(categoryIdGreaterThan);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}

	private static void findByCategoryIdLessThan(Long categoryIdLessThan) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdLessThan(categoryIdLessThan);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	
	private static void findByCategoryIdGreaterThanEqual(Long categoryIdGreaterThanEqual) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdGreaterThanEqual(categoryIdGreaterThanEqual);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	

	private static void findByCategoryIdLessThanEqual(Long categoryIdLessThanEqual) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdLessThanEqual(categoryIdLessThanEqual);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	

	private static void findByCategoryIdBetween(Long categoryIdBetweenMin, Long categoryIdBetweenMax) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdBetween(categoryIdBetweenMin, categoryIdBetweenMax);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	
	private static void findByCategoryNameContainingOrCategoryIdLessThan(String categoryNameContaining,
			Long categoryIdLessThan) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryNameContainingOrCategoryIdLessThan(categoryNameContaining, categoryIdLessThan);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}

	private static void findByCategoryNameEndingWithAndCategoryIdLessThan(String categoryNameEndingWith,
			Long categoryIdLessThan) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryNameEndingWithAndCategoryIdLessThan(categoryNameEndingWith, categoryIdLessThan);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}

	private static void findByCategoryIdNot(Long categoryId) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdNot(categoryId);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}		
	}

	private static void findByCategoryNameContainingOrderByCategoryNameDesc(String categoryNameContaining) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryNameContainingOrderByCategoryNameDesc(categoryNameContaining);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	

	private static void findByCategoryIdLessThanOrderByCategoryNameAsc(Long categoryIdLessThan) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdLessThanOrderByCategoryNameAsc(categoryIdLessThan);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
		
	}
}
