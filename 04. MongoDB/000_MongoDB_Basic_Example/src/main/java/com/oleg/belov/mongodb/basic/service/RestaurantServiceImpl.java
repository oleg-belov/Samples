package com.oleg.belov.mongodb.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
import com.oleg.belov.mongodb.basic.documents.Restaurant;
import com.oleg.belov.mongodb.basic.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService<Restaurant> {
	
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public void insertRestaurantDBObject(DBObject doc) {
		restaurantRepository.insertRestaurantDBObject(doc);
	}

	@Override
	public List<DBObject> findFirstRestaurants(int count) {
		return restaurantRepository.findFirstRestaurants(count);
	}

	@Override
	public List<DBObject> findByName(String name) {
		return restaurantRepository.findByName(name);
	}

	@Override
	public void updateNameByRestaurantId(Long restaurantId, String newRestaurantName) {
		restaurantRepository.updateNameByRestaurantId(restaurantId, newRestaurantName);
	}

	@Override
	public void updateRestauranById(Long restaurantId, DBObject doc) {
		restaurantRepository.updateRestauranById(restaurantId, doc);
		
	}

	@Override
	public void deleteById(Long restaurantId) {
		restaurantRepository.deleteById(restaurantId);
		
	}
}
