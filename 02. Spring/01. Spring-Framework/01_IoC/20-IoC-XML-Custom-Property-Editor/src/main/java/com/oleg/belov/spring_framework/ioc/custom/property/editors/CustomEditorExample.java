package com.oleg.belov.spring_framework.ioc.custom.property.editors;

import static com.oleg.belov.spring_framework.ioc.custom.property.editors.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomEditorExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        CustomEditorExample bean = 
            (CustomEditorExample) ctx.getBean("exampleBean");

        log.info(bean.getName().toString());
    }
}
