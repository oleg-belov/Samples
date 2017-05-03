package com.oleg.belov.spring_framework.ioc.autowire;

import static com.oleg.belov.spring_framework.ioc.autowire.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.oleg.belov.spring_framework.ioc.autowire.beans.Bar;
import com.oleg.belov.spring_framework.ioc.autowire.beans.Foo;

public class Target {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {
    }
    
    public Target(Foo foo) {
         log.debug("Target(Foo) called");
    }
    
    public Target(Foo foo, Bar bar) {
         log.debug("Target(Foo, Bar) called");
    }
    
    public void setFoo(Foo foo) {
        this.foo = foo;
         log.debug("Property foo set");
    }
    
    public void setFoo2(Foo foo) {
        this.foo2 = foo;
         log.debug("Property foo2 set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
         log.debug("Property bar set");
    }

    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        Target t = null;
        
         log.debug("Using byName:\n");
        t = (Target) ctx.getBean("targetByName");
        
         log.debug("\nUsing byType:\n");
        t = (Target) ctx.getBean("targetByType");
        
         log.debug("\nUsing constructor:\n");
        t = (Target) ctx.getBean("targetConstructor");
        
    }
}
