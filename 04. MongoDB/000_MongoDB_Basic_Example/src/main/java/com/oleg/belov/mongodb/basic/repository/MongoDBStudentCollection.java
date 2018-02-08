package com.oleg.belov.mongodb.basic.repository;

import static com.oleg.belov.mongodb.basic.utils.ClassNameUtil.getCurrentClassName;

import java.io.IOException;
import java.util.Arrays;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBStudentCollection  implements MongoDBCollection {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	private String host;
	private String port;
	private String database;
	private String collection;
	private String user;
	private String pws;

	public MongoDBStudentCollection(String host, String port, String database, String collection, String user, String pws) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.collection = collection;
		this.user = user;
		this.pws = pws;
	}
	
	@Override
	@SuppressWarnings({ "resource" })
	public MongoCollection<Document> getCollection() throws IOException {
		log.info("DBCollection: host: " + host + ", port: " + Integer.parseInt(port) + ", user: " + user);

		MongoCredential credential = MongoCredential.createCredential(user, database, pws.toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress(host, Integer.parseInt(port)),
				Arrays.asList(credential));
		MongoDatabase db = mongoClient.getDatabase(database);
		MongoCollection<Document> coll = db.getCollection(collection);

		return coll;
	}
}