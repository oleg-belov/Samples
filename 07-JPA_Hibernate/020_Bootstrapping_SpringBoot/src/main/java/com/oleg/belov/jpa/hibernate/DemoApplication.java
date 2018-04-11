package com.oleg.belov.jpa.hibernate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Set<String> set = new HashSet<>();
		List<String> list = new LinkedList<>();
		set.add("A");
		set.add("S");
		set.add("Z");
		set.add("D");
		set.add("B");
		set.add("I");
		System.out.println(set);
		Map<Integer, String> map = new HashMap<>();
	}
}
