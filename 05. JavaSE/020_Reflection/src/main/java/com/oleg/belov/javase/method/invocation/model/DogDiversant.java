package com.oleg.belov.javase.method.invocation.model;

public class DogDiversant {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {

		throw new UnsupportedOperationException("Can not modify name!");
	}
}
