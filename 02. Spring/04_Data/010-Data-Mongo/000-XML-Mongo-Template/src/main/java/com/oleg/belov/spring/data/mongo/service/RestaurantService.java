package com.oleg.belov.spring.data.mongo.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;

import com.oleg.belov.spring.data.mongo.documents.Restaurant;

public interface RestaurantService {
	public Restaurant findOne(String restaurantId);
	public Restaurant findOneByName(String restaurantName);
	public Restaurant insertRestaurant(Restaurant restaurant);
	public List<Restaurant> findByBoroughAndCuisine(String restaurantBorough, String restaurantCousine);
	public List<Restaurant> findAllByOrderByScoreDesc(TextCriteria criteria);
}
