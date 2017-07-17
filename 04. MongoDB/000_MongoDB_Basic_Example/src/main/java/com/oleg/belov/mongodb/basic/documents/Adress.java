package com.oleg.belov.mongodb.basic.documents;

import java.util.List;

public class Adress {
	private int building;
	private List<Double> coord;
	private String street;
	private int zipCode;
	
	public Adress() {
	}
	
	public Adress(int building, List<Double> coord, String street, int zipCode) {
		super();
		this.building = building;
		this.coord = coord;
		this.street = street;
		this.zipCode = zipCode;
	}

	public int getBuilding() {
		return building;
	}
	public void setBuilding(int building) {
		this.building = building;
	}
	public List<Double> getCoord() {
		return coord;
	}
	public void setCoord(List<Double> coord) {
		this.coord = coord;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Adress [building=" + building + ", coord=" + coord + ", street=" + street + ", zipCode=" + zipCode
				+ "]";
	}
}
