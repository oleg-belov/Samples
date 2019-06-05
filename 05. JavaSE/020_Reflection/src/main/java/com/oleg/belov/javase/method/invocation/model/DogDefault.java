package com.oleg.belov.javase.method.invocation.model;

public class DogDefault {
	private String name;

	public DogDefault() {
		this.setName("Default");
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
