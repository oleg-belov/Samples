package com.oleg.belov.spring_framework.ioc;

import static com.oleg.belov.spring_framework.ioc.utils.ClassNameUtil.getCurrentClassName;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.oleg.belov.spring_framework.ioc.resource.SimpleBean;

public class SpringExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        try {
            se.demoSpring();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void demoSpring() throws IOException {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        //Resource template = context.getResource("spring/resource/test1.txt");
        Resource template2 = context.getResource("classpath:spring/resource/test2.txt");
        
        Resource template = context.getResource("file://spring/resource/test1.txt");
        
        File f = template.getFile();
        log.info("File name:" + f.getAbsolutePath());

        SimpleBean sb = context.getBean("simpleResourceBean", SimpleBean.class);
        log.info("Resource:" + sb.getTemplate().getFile().getAbsolutePath());

        InputStream is = template2.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            log.info("line = " + line);
        }


    }
}
