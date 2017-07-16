package com.oleg.belov.mongodb.basic.repository.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.oleg.belov.mongodb.basic.repository.DataBaseCollection;
import com.oleg.belov.mongodb.basic.repository.RestaurantRepository;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
private DBCollection collection;
	
	@Autowired
	public void setCollection(DataBaseCollection dataBaseCollection) throws IOException {
		this.collection = dataBaseCollection.getCollection();
	}

	@Override
	public void insertRestaurantDBObject(DBObject doc) {
		collection.insert(doc);
	}

	@Override
	public List<DBObject> findFirstRestaurants(int count) {
		DBCursor cursor = collection.find().limit(count);
		List<DBObject> docs = new ArrayList<>();
		
		while(cursor.hasNext()) {
			DBObject doc = cursor.next();
			docs.add(doc);
		}
		return docs;
	}

	@Override
	public List<DBObject> findByName(String name) {
		DBObject query = new BasicDBObject("name", name);
		DBCursor cursor = collection.find(query);
		List<DBObject> docs = new ArrayList<>();
		
		while(cursor.hasNext()) {
			DBObject doc = cursor.next();
			docs.add(doc);
		}
		return docs;
	}

	@Override
	public void updateNameByRestaurantId(Long restaurantId, String newRestaurantName) {
		DBObject newDocument = new BasicDBObject();
		newDocument.put("name", newRestaurantName);
		
		DBObject searchQuery = new BasicDBObject().append("restaurant_id", restaurantId);
		collection.update(searchQuery, newDocument);
	}

	@Override
	public void updateRestauranById(Long restaurantId, DBObject doc) {
		DBObject newDocument = new BasicDBObject();
		newDocument.put("$set", doc);
		
		DBObject searchQuery = new BasicDBObject().append("restaurant_id", restaurantId);
		collection.update(searchQuery, newDocument);
	}

	@Override
	public void deleteById(Long restaurantId) {
		DBObject doc = new BasicDBObject();
		doc.put("restaurant_id", restaurantId);
		
		collection.remove(doc);
	}
}
