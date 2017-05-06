package com.oleg.belov.spring_framework.ioc.validationexample;


import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oleg.belov.spring_framework.ioc.validationexample.dao.RegionDao;
import com.oleg.belov.spring_framework.ioc.validationexample.model.Region;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        try {
            se.demoSpring();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void demoSpring() throws IOException {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        RegionDao dao = (RegionDao) ctx.getBean("regionDao");

        Region region1 = new Region();
        region1.setRegionId(1);
        region1.setRegionName("SPB");
        region1.setPopulation(10000000);

        dao.saveRegion(region1);

        Region region2 = new Region();
        region2.setRegionId(1);
        region2.setRegionName("");
        region2.setPopulation(-1);

        dao.saveRegion(region2);


    }
}
