package com.oleg.belov.spring.data.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.oleg.belov.spring.data.mongo.documents.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
	Restaurant findOneByName(String name);

	@Query(value="{'borough' : ?0, 'cuisine' : ?1}")
	List<Restaurant> findByBoroughAndCuisine(String restaurantBorough, String restaurantCousine);

	List<Restaurant> findAllByOrderByScoreDesc(TextCriteria criteria);
}
