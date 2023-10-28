package com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.service;

import com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.model.Restaurant;
import org.springframework.data.mongodb.core.MongoTemplate;

public class RestaurantService {

    private MongoTemplate hotelMongoDb;

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return hotelMongoDb.save(restaurant);
    }


    public Restaurant getRestaurant(String restaurantId) {
        return hotelMongoDb.findById(restaurantId, Restaurant.class);
    }

}
