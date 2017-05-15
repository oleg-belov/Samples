package com.oleg.belov.spring.dao.jdbc;

import static com.oleg.belov.spring.dao.jdbc.utils.ClassNameUtil.getCurrentClassName;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring.dao.jdbc.service.BookService;


public class SpringExample {
	public static BookService bookService;
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
        bookService = context.getBean("bookService", BookService.class);
 
        log.info("The number of books is: " + bookService.getNumberOfBooks() + "\n");
        
        List<String> booksNames = bookService.getAllBookNames();
        for(String bookName : bookName) {
        	log.info(bookName);
        }
        		
        log.info("Get book by name: " + bookService.getBookByName("Java 8. Полное руководство"));
         
    }
}
