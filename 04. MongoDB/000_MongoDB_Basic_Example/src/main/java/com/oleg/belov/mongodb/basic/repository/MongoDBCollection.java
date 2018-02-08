package com.oleg.belov.mongodb.basic.repository;

import java.io.IOException;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public interface MongoDBCollection {
	public MongoCollection<Document> getCollection() throws IOException;
}
