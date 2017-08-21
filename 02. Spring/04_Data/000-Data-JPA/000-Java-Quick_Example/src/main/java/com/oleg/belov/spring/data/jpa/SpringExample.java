package com.oleg.belov.spring.data.jpa;

import static com.oleg.belov.spring.data.jpa.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringExample {
	
//	@Qualifier("bookServiceImpl")
//	public static BLibraryService<Book> bookServiceImpl;
	
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
    
//	@Autowired
//	public SpringExample(BLibraryService<Book> bookServiceImpl) {
//		this.bookServiceImpl = bookServiceImpl;
//	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
      
	}
}
