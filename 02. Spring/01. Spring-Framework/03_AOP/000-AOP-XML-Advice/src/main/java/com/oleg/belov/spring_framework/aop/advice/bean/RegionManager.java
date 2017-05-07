package com.oleg.belov.spring_framework.aop.advice.bean;

import static com.oleg.belov.spring_framework.aop.advice.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegionManager {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    private String name;
    private int number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void getInfo() {
        log.info("Name = " + name + " number= " + number);
    }

    public void throwException() {
        throw new IllegalArgumentException();
    }

}
