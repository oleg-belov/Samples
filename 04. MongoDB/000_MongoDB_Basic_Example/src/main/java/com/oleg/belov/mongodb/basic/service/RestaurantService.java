package com.oleg.belov.mongodb.basic.service;

import java.util.List;

import com.mongodb.DBObject;

public interface RestaurantService<T> {
	public void insertRestaurantDBObject(DBObject doc);

	public List<DBObject> findFirstRestaurants(int count);

	public List<DBObject> findByName(String name);

	public void updateNameByRestaurantId(Long restaurantId, String newRestaurantName);

	public void updateRestauranById(Long restaurantId, DBObject doc);

	public void deleteById(Long restaurantId);
}
