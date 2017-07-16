package com.oleg.belov.mongodb.basic.documents;

import java.util.List;

public class Restaurant {
	private String objectId;
	private Adress adress;
	private String borough;
	private String cuisine;
	private List<Grade> grades;
	private String name;
	private Long restaurantId;

	public Restaurant() {
	}

	public Restaurant(String objectId, Adress adress, String borough, String cuisine, List<Grade> grades, String name,
			Long restaurantId) {
		this.objectId = objectId;
		this.adress = adress;
		this.borough = borough;
		this.cuisine = cuisine;
		this.grades = grades;
		this.name = name;
		this.restaurantId = restaurantId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getBorough() {
		return borough;
	}

	public void setBorough(String borough) {
		this.borough = borough;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
}
