package com.oleg.belov.spring_framework.ioc.constructor.based.di;

import static com.oleg.belov.spring_framework.ioc.constructor.based.di.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorConfusion {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    private String someValue;

    public ConstructorConfusion(String someValue) {
    	log.debug("ConstructorConfusion(String) called"); 
        this.someValue = someValue;
    }

	public ConstructorConfusion(int someValue) {
		log.debug("ConstructorConfusion(int) called"); 
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
        log.debug(cc.toString()); 
        
        ConfigurableMessageProvider cm = (ConfigurableMessageProvider) ctx.getBean("messageProvider");
        log.info("The message is : " + cm.getMessage());
    }

    public String toString() {
        return someValue; 
    }
}
