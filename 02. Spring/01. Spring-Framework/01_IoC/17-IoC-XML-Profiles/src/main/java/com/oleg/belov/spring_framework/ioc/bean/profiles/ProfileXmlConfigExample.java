package com.oleg.belov.spring_framework.ioc.bean.profiles;

import static com.oleg.belov.spring_framework.ioc.bean.profiles.utils.ClassNameUtil.getCurrentClassName;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileXmlConfigExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:*-config.xml");
        ctx.refresh();
        
        FoodProviderService foodProviderService =    
            ctx.getBean("foodProviderService", FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();

        for (Food food: lunchSet) {
           log.info("Food: " + food.getName());
        }
    }
}
