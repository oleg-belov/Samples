package com.oleg.belov.mongodb.basic.repository;

import static com.oleg.belov.mongodb.basic.utils.ClassNameUtil.getCurrentClassName;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class DataBaseCollection {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
	private static String host;
	private static String port;
	private static String database;
	private static String collection;
	private static String user;
	private static String pws;

	@SuppressWarnings("static-access")
	public DataBaseCollection(String host, String port, String database, String collection, String user, String pws) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.collection = collection;
		this.user = user;
		this.pws = pws;
	}

	@SuppressWarnings({ "resource", "deprecation" })
	public DBCollection getCollection() throws IOException {
		log.info("DBCollection: host: " +  host + ", port: " + Integer.parseInt(port) + ", user: "
				+ user + ", pws: " + pws.toCharArray());
		
		MongoCredential credential = MongoCredential.createCredential(user, database, pws.toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress(host, Integer.parseInt(port)),
				Arrays.asList(credential));
		DB db = mongoClient.getDB(database);
		DBCollection coll = db.getCollection(collection);
		
		
		return coll;
	}

	
}
