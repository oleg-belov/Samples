package com.oleg.belov.spring.data.mongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.oleg.belov.spring.data.mongo.documents.Restaurant;
import com.oleg.belov.spring.data.mongo.repository.RestaurantRepository;
import com.oleg.belov.spring.data.mongo.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public Restaurant findOneByName(String restaurantName) {
		return restaurantRepository.findOneByName(restaurantName);
	}

	@Override
	public Restaurant findOne(String restaurantId) {
		return restaurantRepository.findOne(restaurantId);
	}

	@Override
	public Restaurant insertRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
		
	}

	@Override
	public List<Restaurant> findByBoroughAndCuisine(String restaurantBorough, String restaurantCousine) {
		return restaurantRepository.findByBoroughAndCuisine(restaurantBorough, restaurantCousine);
	}

	@Override
	public List<Restaurant> findAllByOrderByScoreDesc(TextCriteria criteria) {
		return restaurantRepository.findAllByOrderByScoreDesc(criteria);
	}
}
