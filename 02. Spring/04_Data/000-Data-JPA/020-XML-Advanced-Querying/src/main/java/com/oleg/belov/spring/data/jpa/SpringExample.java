package com.oleg.belov.spring.data.jpa;

import static com.oleg.belov.spring.data.jpa.utils.ClassNameUtil.getCurrentClassName;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		
		findAllBookCategorys();
		log.info("\n");
		findByCategoryIdLessThanEqual(CATEGORY_ID_LESS_THAN_EQUAL);
		log.info("\n");
		findByCategoryName(CATEGORY_NAME);
		log.info("\n");
		findByCategoryIdGteaterThanEquals(CATEGORY_ID_GREATER_THAN_EQUAL);
		log.info("\n");
		
		findAllPageable(new PageRequest(PAGEABLE_PAGE, PAGEABLE_SIZE));
		log.info("\n");
		findByCategoryIdGreaterThanPageable(CATEGORY_ID_GREATER_THAN, new PageRequest(PAGEABLE_PAGE, PAGEABLE_SIZE));
		log.info("\n");
		findAllSort(new Sort(Sort.Direction.DESC, "categoryId"));
	}

	private static void findAllBookCategorys() {
		List<BookCategory> bookCategories = bookStoreService.findAllBookCategorys();
		
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
	
	private static void findByCategoryName(String categoryName) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryName(categoryName);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}

	private static void findByCategoryIdGteaterThanEquals(Long categoryIdGreaterThanEqual) {
		List<BookCategory> bookCategories = bookStoreService.findByCategoryIdGteaterThanEquals(categoryIdGreaterThanEqual);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}

	private static void findAllPageable(PageRequest pageRequest) {
		Page<BookCategory> bookCategories = bookStoreService.findAllByPage(pageRequest);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	
	private static void findByCategoryIdGreaterThanPageable(Long categoryIdGreaterThan, PageRequest pageRequest) {
		Page<BookCategory> bookCategories = bookStoreService.findByCategoryIdGreaterThanPageable(categoryIdGreaterThan, pageRequest);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
	

	private static void findAllSort(Sort sort) {
		List<BookCategory> bookCategories = bookStoreService.findAllSort(sort);
		
		for(BookCategory bobookCategorie : bookCategories){
			log.info(bobookCategorie.toString());
		}
	}
}
