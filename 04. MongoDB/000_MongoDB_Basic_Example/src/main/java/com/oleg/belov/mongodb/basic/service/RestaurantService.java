package com.oleg.belov.mongodb.basic.service;

import java.util.List;

import org.bson.Document;

import com.oleg.belov.mongodb.basic.documents.Restaurant;

public interface RestaurantService {
	public void insertRestaurantDBObject(Document doc);

	public List<Document> findFirstRestaurants(int count);

	public List<Document> findByName(String name);

	public void updateNameByRestaurantId(Long restaurantId, String newRestaurantName);

	public void updateRestauranById(Long restaurantId, Document doc);

	public void deleteByRestaurantId(Long restaurantId);

	public Restaurant findbyRestaurantId(Long restaurantId);

	public void insertRestaurant(Restaurant restauranr);

	public void bulkInsertRestaurants(List<Restaurant> restaurantList);
}
