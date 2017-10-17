package com.oleg.belov.spring.data.mongo.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Document(collection="restaurants")
public class Restaurant {
	@Id
	private String id;
	private Adress adress;
	@TextIndexed(weight=3)
	private String borough;
	@TextIndexed(weight=2)
	private String cuisine;
	private List<Grade> grades;
	@TextIndexed(weight=1)
	@Field(value = "name")
	private String name;
	@Field(value = "restaurant_id")
	private Long restaurantId;
	@TextScore
	private Float score;

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

	public Restaurant(String id, Adress adress, String borough, String cuisine, List<Grade> grades, String name,
			Long restaurantId) {
		this.id = id;
		this.adress = adress;
		this.borough = borough;
		this.cuisine = cuisine;
		this.grades = grades;
		this.name = name;
		this.restaurantId = restaurantId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", adress=" + adress + ", borough=" + borough + ", cuisine=" + cuisine
				+ ", grades=" + grades + ", name=" + name + ", restaurantId=" + restaurantId + ", score=" + score + "]";
	}
}
