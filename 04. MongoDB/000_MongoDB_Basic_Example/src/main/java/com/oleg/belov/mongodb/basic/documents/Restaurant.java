package com.oleg.belov.mongodb.basic.documents;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Restaurant {
	@SerializedName("_id")
	private Object id;
	private Adress adress;
	private String borough;
	private String cuisine;
	private List<Grade> grades;
	private String name;
	@SerializedName("restaurant_id")
	private Long restaurantId;

	public Restaurant() {
	}
	
	

	public Restaurant(Adress adress, String borough, String cuisine, List<Grade> grades, String name,
			Long restaurantId) {
		super();
		this.adress = adress;
		this.borough = borough;
		this.cuisine = cuisine;
		this.grades = grades;
		this.name = name;
		this.restaurantId = restaurantId;
	}

	public Restaurant(Object id, Adress adress, String borough, String cuisine, List<Grade> grades, String name,
			Long restaurantId) {
		this.id = id;
		this.adress = adress;
		this.borough = borough;
		this.cuisine = cuisine;
		this.grades = grades;
		this.name = name;
		this.restaurantId = restaurantId;
	}

	public Object getObjectId() {
		return id;
	}

	public void setObjectId(Object id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", adress=" + adress + ", borough=" + borough + ", cuisine="
				+ cuisine + ", grades=" + grades + ", name=" + name + ", restaurantId=" + restaurantId + "]";
	}
}
