package com.oleg.belov.mongodb.basic.repository.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.oleg.belov.mongodb.basic.documents.Restaurant;
import com.oleg.belov.mongodb.basic.repository.MongoDBCollection;
import com.oleg.belov.mongodb.basic.repository.RestaurantRepository;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
	private MongoCollection<Document> restaurantCollection;
	
	@Autowired
	public void setCollection(MongoDBCollection restaurantCollection) throws IOException {
		this.restaurantCollection = restaurantCollection.getCollection();
	}

	@Override
	public void insertRestaurantDBObject(Document doc) {
		restaurantCollection.insertOne(doc);
	}

	@Override
	public List<Document> findFirstRestaurants(int count) {
		MongoCursor<Document>  cursor = restaurantCollection.find().limit(count).iterator();
		List<Document> docs = new ArrayList<>();
		
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			docs.add(doc);
		}
		return docs;
	}

	@Override
	public List<Document> findByName(String name) {
		Document query = new Document("name", name);
		MongoCursor<Document> cursor = restaurantCollection.find(query).iterator();
		List<Document> docs = new ArrayList<>();
		
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			docs.add(doc);
		}
		return docs;
	}

	@Override
	public void updateNameByRestaurantId(Long restaurantId, String newRestaurantName) {
		Document newDocument = new Document();
		newDocument.put("$set", new Document( "name", newRestaurantName));
		
		Document searchQuery = new Document().append("restaurant_id", restaurantId);
		restaurantCollection.updateOne(searchQuery, newDocument);
	}

	@Override
	public void updateRestauranById(Long restaurantId, Document doc) {
		Document newDocument = new Document();
		newDocument.put("$set", doc);
		
		Document searchQuery = new Document().append("restaurant_id", restaurantId);
		restaurantCollection.updateOne(searchQuery, newDocument);
	}

	@Override
	public void deleteByRestaurantId(Long restaurantId) {
		Document doc = new Document();
		doc.put("restaurant_id", restaurantId);
		
		restaurantCollection.deleteOne(doc);
	}

	@Override
	public Restaurant findbyRestaurantId(Long restaurantId) {
		Gson gson = new Gson();
		Document doc = restaurantCollection.find(new Document("restaurant_id", restaurantId)).first();
		Restaurant restaurant = gson.fromJson(doc.toJson(), Restaurant.class);
		
		return restaurant;
	}

	@Override
	public void insertRestaurant(Restaurant restauranr) {
		Gson gson = new Gson();
		Document doc =  Document.parse(gson.toJson(restauranr));
		restaurantCollection.insertOne(doc);
	}

	@Override
	public void bulkInsertRestaurants(List<Restaurant> restaurantList) {
		List<Document> docs = new ArrayList<>();
		for(Restaurant restaurant :restaurantList) {
			Gson gson = new Gson();
			Document doc =  Document.parse(gson.toJson(restaurant));
			docs.add(doc);
		}
			
		restaurantCollection.insertMany(docs);
	}
}
