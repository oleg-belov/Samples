package com.oleg.belov.spring_framework.aop.aspectj.bean;

import static com.oleg.belov.spring_framework.aop.aspectj.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CityManager {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	private String name;
	private int number;

	public void createCity(String name) throws IllegalArgumentException {
		if (name == null)
			throw new IllegalArgumentException("Name must be not null");
		log.info("Create city...");
	}

	public void deleteCity() {
		System.out.println("Delete region...");
	}

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

}
