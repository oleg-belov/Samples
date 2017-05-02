package com.oleg.belov.spring_framework.ioc.constructor.based.di;

import static com.oleg.belov.spring_framework.ioc.constructor.based.di.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("constructorConfusion")
public class ConstructorConfusion {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    private String someValue;

    public ConstructorConfusion() {
    }

    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
        log.info(cc.toString()); 
        
        ConfigurableMessageProvider cm = (ConfigurableMessageProvider) ctx.getBean("messageProvider");
        log.info("The message is : " + cm.getMessage());
    }

    public String toString() {
        return someValue; 
    }
    
    @Autowired
	public void setSomeValue(@Value("90") String someValue) {
		this.someValue = someValue;
	}
    
}
