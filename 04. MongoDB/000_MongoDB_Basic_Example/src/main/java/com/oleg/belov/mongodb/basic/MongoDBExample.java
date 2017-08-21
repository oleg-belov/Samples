package com.oleg.belov.mongodb.basic;

import static com.oleg.belov.mongodb.basic.utils.ClassNameUtil.getCurrentClassName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.oleg.belov.mongodb.basic.documents.Adress;
import com.oleg.belov.mongodb.basic.documents.Grade;
import com.oleg.belov.mongodb.basic.documents.Restaurant;
import com.oleg.belov.mongodb.basic.service.RestaurantService;

@Component
@SuppressWarnings({ "static-access", "unused" })
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
		@SuppressWarnings({ "resource" })
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"mongoDBExample.xml"});
        
//		insertRestaurantDBObject();
//		findFirstTenRestaurants(COUNT);
//		findByName(RESTAURANT_NAME);
//		updateNameByRestaurantId(RESTAURANT_ID, NEW_RESTAURANT_NAME);
//		updateRestauranById(RESTAURANT_ID);
//		deleteByRestaurantId(RESTAURANT_ID);
//		findbyRestaurantId(RESTAURANT_ID);
//		insertRestaurant();
		bulkInsertRestaurants();
	}
	
	private static void bulkInsertRestaurants() {
		List<Restaurant> restaurantList = new ArrayList<>();
		for(long i = 12345678903L; i < 12345678913L; i++) {
			Restaurant restauranr = new Restaurant(
					new Adress(27, new ArrayList<Double>(Arrays.asList(25.00, 75.00)),  "Frunze 1k street", 12345),
					"Queens", "Delicatessen",  new ArrayList<Grade>(Arrays.asList(
						new Grade(new Date(),'C', 20),
						new Grade(new Date(), 'B', 25),
						new Grade(new Date(), 'D', 15)))
					, NEW_RESTAURANT_NAME, i);
			restaurantList.add(restauranr);
		}
		restaurantService.bulkInsertRestaurants(restaurantList);
		log.info("Is succesful inserted: " + (12345678913L - 12345678903L) + ", restaurants.");
	}

	private static void insertRestaurant() {
		Restaurant restauranr = new Restaurant(
				new Adress(27, new ArrayList<Double>(Arrays.asList(25.00, 75.00)),  "Frunze 1k street", 12345),
				"Queens", "Delicatessen",  new ArrayList<Grade>(Arrays.asList(
					new Grade(new Date(),'C', 20),
					new Grade(new Date(), 'B', 25),
					new Grade(new Date(), 'D', 15)))
				, NEW_RESTAURANT_NAME, 12345678902L);
		
		restaurantService.insertRestaurant(restauranr);
		log.info("Restaurant: " + restauranr + ", is succesful inserted.");
	}

	private static void findbyRestaurantId(Long restaurantId) {
		Restaurant restaurant = restaurantService.findbyRestaurantId(restaurantId);
		log.info("Restaurant with id: " + restaurantId + " is: " + restaurant);
		
	}

	private static void deleteByRestaurantId(Long restaurantId) {
		restaurantService.deleteByRestaurantId(restaurantId);
		log.info("Restaurant with id: " + restaurantId + " is succesfull removed");
	}

	private static void updateRestauranById(Long restaurantId) {
		Document doc = new Document("adress", new Document("building", 27)
				.append("coord", new ArrayList<Double>(Arrays.asList(25.00, 75.00)))
				.append("street", "Frunze 1k street")
				.append("zipcode", 12345))
					.append("boroght", "Queens")
					.append("cousine", "Delicatessen")
					.append("grades", new ArrayList<Document>(Arrays.asList(
							new Document("date", new Date())
								.append("grade", "C")
								.append("score", 20),
								new Document("date", new Date())
								.append("grade", "B")
								.append("score", 25),
								new Document("date", new Date())
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
	private static void updateNameByRestaurantId(Long restaurantId, String newRestaurantName) {
		restaurantService.updateNameByRestaurantId(restaurantId, newRestaurantName);
		log.info("Restaurant with id: " + restaurantId + " is succesfull updated");
	}

	private static void findByName(String name) {
		List<Document> docs = restaurantService.findByName(name);
		for(Document doc : docs)
			log.info(doc.toString());
	}

	private static void findFirstTenRestaurants(int count) {
		List<Document> docs = restaurantService.findFirstRestaurants(count);
		for(Document doc : docs)
			log.info(doc.toString());
	}

	private static void insertRestaurantDBObject() {
		Document doc = new Document("adress", new BasicDBObject("building", 27)
				.append("coord", new ArrayList<Double>(Arrays.asList(25.00, 75.00)))
				.append("street", "Frunze 1k street")
				.append("zipcode", 12345))
					.append("boroght", "Queens")
					.append("cousine", "Delicatessen")
					.append("grades", new ArrayList<Document>(Arrays.asList(
							new Document("date", new Date())
								.append("grade", "C")
								.append("score", 20),
								new Document("date", new Date())
								.append("grade", "B")
								.append("score", 25),
								new Document("date", new Date())
								.append("grade", "d")
								.append("score", 15))))
					.append("name", "Glorious Food")
					.append("restaurant_id", 1234567890);
		
		restaurantService.insertRestaurantDBObject(doc);
		log.info("Inserted doc: " + doc.toString());
	}
}