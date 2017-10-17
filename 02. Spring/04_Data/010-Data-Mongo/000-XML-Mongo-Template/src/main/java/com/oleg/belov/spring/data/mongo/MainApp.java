package com.oleg.belov.spring.data.mongo;

import static com.oleg.belov.spring.data.mongo.utils.ClassNameUtil.getCurrentClassName;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Component;

import com.oleg.belov.spring.data.mongo.documents.Adress;
import com.oleg.belov.spring.data.mongo.documents.Grade;
import com.oleg.belov.spring.data.mongo.documents.Restaurant;
import com.oleg.belov.spring.data.mongo.service.RestaurantService;

@Component
@SuppressWarnings({"static-access", "unused", "resource"})
public class MainApp {
	private final static String RESTAURANT_OBJECT_ID = "59e44a2b5ff6881c044147e9";
	private final static String RESTAURANT_NAME = "Carvel Ice Cream";
	private final static String NEW_RESTAURANT_NAME = "La Crisma";
	private final static Long RESTAURANT_ID = 1234567890L;
	private final static String RESTAURANT_BOROUGH = "Bronx";
	private final static String RESTAURANT_COUSINE = "African";
	private final static String RESTAURANT_FULL_TEXT_SEARCH = "C";
	
	private static RestaurantService restaurantService;
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
	@Autowired
	public MainApp(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"mongoDBExample.xml"});
		
		findOneByObjectId(RESTAURANT_OBJECT_ID);
//		findOneByName(RESTAURANT_NAME);
//		insertRestaurant();
//		findByBoroughAndCuisine(RESTAURANT_BOROUGH, RESTAURANT_COUSINE); 
//		findAllByOrderByScoreDesc(RESTAURANT_FULL_TEXT_SEARCH);
	}

	private static void findOneByObjectId(String restaurantObjectId) {
		Restaurant restaurantById = restaurantService.findOne(restaurantObjectId);
		log.info(restaurantById.toString());
	}
	
	private static void findOneByName(String restaurantName) {
		Restaurant restaurantById = restaurantService.findOneByName(restaurantName);
		log.info(restaurantById.toString());
	}
	
	private static void insertRestaurant() {
		Restaurant restaurant = new Restaurant(
				new Adress(27, new ArrayList<Double>(Arrays.asList(25.00, 75.00)),  "Frunze 1k street", 12345),
				"Queens", "Delicatessen",  new ArrayList<Grade>(Arrays.asList(
					new Grade(new Date(),"C", 20),
					new Grade(new Date(), "B", 25),
					new Grade(new Date(), "D", 15)))
				, NEW_RESTAURANT_NAME, RESTAURANT_ID);
		
		restaurant = restaurantService.insertRestaurant(restaurant);
		log.info("Restaurant: " + restaurant + ", is succesful inserted.");
	}
	

	private static void findByBoroughAndCuisine(String restaurantBorough, String restaurantCousine) {
		List<Restaurant> restaurants = restaurantService.findByBoroughAndCuisine(restaurantBorough, restaurantCousine);
		restaurants.forEach(restaurant -> log.info(restaurant.toString()));
	}
	
	private static void findAllByOrderByScoreDesc(String srt) {
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matching(srt);
		List<Restaurant> restaurants = restaurantService.findAllByOrderByScoreDesc(criteria);
		restaurants.forEach(restaurant -> log.info(restaurant.toString()));
		
	}
}
