package com.oleg.belov.mongodb.basic;

import static com.oleg.belov.mongodb.basic.utils.ClassNameUtil.getCurrentClassName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.oleg.belov.mongodb.basic.service.RestaurantService;

@Component
@SuppressWarnings({ "static-access", "rawtypes" })
public class MongoDBExample {
	private final static int COUNT = 10;
	private final static String RESTAURANT_NAME = "Carvel Ice Cream";
	private final static String NEW_RESTAURANT_NAME = "La Crisma";
	private final static Long RESTAURANT_ID = 1234567890L;
	private static RestaurantService restaurantService;
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
    
	
	@Autowired
	public MongoDBExample(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"mongoDBExample.xml"});
        
		//insertRestaurantDBObject();
		//findFirstTenRestaurants(COUNT);
		//findByName(RESTAURANT_NAME);
		//updateNameByRestaurantId(RESTAURANT_ID, NEW_RESTAURANT_NAME);
		//updateRestauranById(RESTAURANT_ID);
		deleteById(RESTAURANT_ID);
	}
	
	private static void deleteById(Long restaurantId) {
		restaurantService.deleteById(restaurantId);
		log.info("Restaurant with id: " + restaurantId + " is succesfull removed");
	}

	@SuppressWarnings("unused")
	private static void updateRestauranById(Long restaurantId) {
		DBObject doc = new BasicDBObject("adress", new BasicDBObject("building", 27)
				.append("coord", new ArrayList<Double>(Arrays.asList(25.00, 75.00)))
				.append("street", "Frunze 1k street")
				.append("zipcode", 12345))
					.append("boroght", "Queens")
					.append("cousine", "Delicatessen")
					.append("grades", new ArrayList<DBObject>(Arrays.asList(
							new BasicDBObject("date", new Date())
								.append("grade", "C")
								.append("score", 20),
								new BasicDBObject("date", new Date())
								.append("grade", "B")
								.append("score", 25),
								new BasicDBObject("date", new Date())
								.append("grade", "d")
								.append("score", 15))))
					.append("name", NEW_RESTAURANT_NAME);
		
		restaurantService.updateRestauranById(restaurantId, doc);
		log.info("Restaurant with id: " + restaurantId + " is succesfull updated");
	}

	/**
	 * the update statement will replace the original document with
	 * another one, including only the keys and values passed to the update
	 * @param restaurantId
	 * @param newRestaurantName
	 */
	@SuppressWarnings("unused")
	private static void updateNameByRestaurantId(Long restaurantId, String newRestaurantName) {
		restaurantService.updateNameByRestaurantId(restaurantId, newRestaurantName);
		log.info("Restaurant with id: " + restaurantId + " is succesfull updated");
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private static void findByName(String name) {
		List<DBObject> docs = restaurantService.findByName(name);
		for(DBObject doc : docs)
			log.info(doc.toString());
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private static void findFirstTenRestaurants(int count) {
		List<DBObject> docs = restaurantService.findFirstRestaurants(count);
		for(DBObject doc : docs)
			log.info(doc.toString());
	}

	@SuppressWarnings("unused")
	private static void insertRestaurantDBObject() {
		DBObject doc = new BasicDBObject("adress", new BasicDBObject("building", 27)
				.append("coord", new ArrayList<Double>(Arrays.asList(25.00, 75.00)))
				.append("street", "Frunze 1k street")
				.append("zipcode", 12345))
					.append("boroght", "Queens")
					.append("cousine", "Delicatessen")
					.append("grades", new ArrayList<DBObject>(Arrays.asList(
							new BasicDBObject("date", new Date())
								.append("grade", "C")
								.append("score", 20),
								new BasicDBObject("date", new Date())
								.append("grade", "B")
								.append("score", 25),
								new BasicDBObject("date", new Date())
								.append("grade", "d")
								.append("score", 15))))
					.append("name", "Glorious Food")
					.append("restaurant_id", 1234567890);
		
		restaurantService.insertRestaurantDBObject(doc);
		log.info("Inserted doc: " + doc.toString());
	}
}