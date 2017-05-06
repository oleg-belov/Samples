package com.oleg.belov.spring_framework.ioc.message.source;

import static com.oleg.belov.spring_framework.ioc.utils.ClassNameUtil.getCurrentClassName;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSourceDemo {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");

        log.info(ctx.getMessage("msg", null, english));
        log.info(ctx.getMessage("msg", null, czech));

        log.info(ctx.getMessage("nameMsg", new Object[] { "Oleg",
                "Belov" }, english));
    }
}
