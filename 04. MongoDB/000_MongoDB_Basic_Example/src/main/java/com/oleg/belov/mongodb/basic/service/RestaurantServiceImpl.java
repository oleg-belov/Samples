package com.oleg.belov.mongodb.basic.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void insertRestaurantDBObject(Document doc) {
		restaurantRepository.insertRestaurantDBObject(doc);
	}

	@Override
	public List<Document> findFirstRestaurants(int count) {
		return restaurantRepository.findFirstRestaurants(count);
	}

	@Override
	public List<Document> findByName(String name) {
		return restaurantRepository.findByName(name);
	}

	@Override
	public void updateNameByRestaurantId(Long restaurantId, String newRestaurantName) {
		restaurantRepository.updateNameByRestaurantId(restaurantId, newRestaurantName);
	}

	@Override
	public void updateRestauranById(Long restaurantId, Document doc) {
		restaurantRepository.updateRestauranById(restaurantId, doc);
		
	}

	@Override
	public void deleteByRestaurantId(Long restaurantId) {
		restaurantRepository.deleteByRestaurantId(restaurantId);
		
	}

	@Override
	public Restaurant findbyRestaurantId(Long restaurantId) {
		return restaurantRepository.findbyRestaurantId(restaurantId);
	}

	@Override
	public void insertRestaurant(Restaurant restauranr) {
		 restaurantRepository.insertRestaurant(restauranr);
	}

	@Override
	public void bulkInsertRestaurants(List<Restaurant> restaurantList) {
		restaurantRepository.bulkInsertRestaurants(restaurantList);
	}
}
