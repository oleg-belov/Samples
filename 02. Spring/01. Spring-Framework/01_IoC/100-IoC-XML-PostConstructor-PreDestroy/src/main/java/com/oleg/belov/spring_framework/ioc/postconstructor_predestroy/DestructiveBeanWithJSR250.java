package com.oleg.belov.spring_framework.ioc.postconstructor_predestroy;

import static com.oleg.belov.spring_framework.ioc.postconstructor_predestroy.utils.ClassNameUtil.getCurrentClassName;

import java.io.File;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBeanWithJSR250 {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    private File file;
    private String filePath;
    
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
       log.debug("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " + 
                    DestructiveBeanWithJSR250.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

       log.debug("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
       log.debug("Destroying Bean");

        if(!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }

       log.debug("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(new String[]{"springContext.xml"});
        ctx.refresh(); 

        DestructiveBeanWithJSR250 bean = 
            (DestructiveBeanWithJSR250) ctx.getBean("destructiveBean");

       log.debug("Calling destroy()");
        ctx.destroy();
       log.debug("Called destroy()");
    }
}
