package com.oleg.belov.spring_framework.ioc.collection;

import static com.oleg.belov.spring_framework.ioc.utils.ClassNameUtil.getCurrentClassName;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionInjection {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName()); 
	
    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
 

        CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
        instance.displayInfo();
    }
    
    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map <String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void displayInfo() {
        log.debug("Map contents:\n");

        for (Map.Entry<String, Object> entry: map.entrySet()) {
            log.debug("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }

        log.debug("\nProperties contents:\n");

        for (Map.Entry<Object, Object> entry: props.entrySet()) {
            log.debug("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }

        log.debug("\nSet contents:\n");

        for (Object obj: set) {
            log.debug("Value: " + obj);
        }
        log.debug("\nList contents:\n");

        for (Object obj: list) {
            log.debug("Value: " + obj);
        }
    }
}
