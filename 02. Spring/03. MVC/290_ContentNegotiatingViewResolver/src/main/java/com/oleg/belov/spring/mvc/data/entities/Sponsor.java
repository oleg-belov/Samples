package com.oleg.belov.spring.mvc.data.entities;

public class Sponsor {

	private String name;

	private String phone;

	private String email;

	public Sponsor() {
	}

	public Sponsor(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Sponsor [name=" + name + ", phone=" + phone + ", email="
				+ email + "]";
	}

}
