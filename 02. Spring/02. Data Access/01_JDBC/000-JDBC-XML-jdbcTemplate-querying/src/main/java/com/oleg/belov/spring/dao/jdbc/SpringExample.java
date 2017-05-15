package com.oleg.belov.spring.dao.jdbc;

import static com.oleg.belov.spring.dao.jdbc.utils.ClassNameUtil.getCurrentClassName;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.oleg.belov.spring.dao.jdbc.service.BLibraryService;
import com.oleg.belov.spring.dao.jdbc.entity.Book;

@Component
public class SpringExample {
	
	public static BLibraryService bLibraryService;
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
    
	@Autowired
	public SpringExample(BLibraryService bLibraryService) {
		this.bLibraryService = bLibraryService;
	}
	
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
        
        log.info("\nThe number of books is: " + bLibraryService.getNumberOfBooks() + "\n");
        
        log.info("\nGet BooK By Id(1): " + bLibraryService.getById(1L).toString() + "\n");
        
		Map<String, Object> book = bLibraryService.getByIdInMap(2L);
        log.info("\nGet BooK By Id in Map(2): " + book.toString() + "\n");
        		
       List<Map<String, Object>> books = bLibraryService.getAllBooksInMap();
       for(Map<String, Object> bookMap : books) {
    	   log.info("\n" + bookMap.toString() + "\n");
       }
       
       log.info("\nGet BooK By Date(2015) and Language (русский): " + 
    		   bLibraryService.getByDateAndLanguage(2015, "русский").toString() + "\n");
       
       List<Book> booksList = bLibraryService.getAllBooks();
       for(Book bookObject : booksList) {
    	   log.info("\n" + bookObject.toString() + "\n");
       }
       
       //============Inserting, Deleting, and Updating Rows======================//
       log.info("\nRows Inserted: " + bLibraryService.insertAuthor("Martin Fowler", new Date(1963)) + "\n");
       
       log.info("\nRows Updated: " + bLibraryService.updateAuthorBirthDateById(4L , new Date(1964)) + "\n");
       
       bLibraryService.dropAuthorTable();
       log.info("\nAuthor table is deleted!");
      
	}
}
