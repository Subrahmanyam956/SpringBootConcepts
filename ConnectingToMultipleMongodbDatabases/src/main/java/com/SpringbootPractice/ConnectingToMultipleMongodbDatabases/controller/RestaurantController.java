package com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.controller;

import com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.model.Customer;
import com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.model.Restaurant;
import com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.service.CustomerService;
import com.SpringbootPractice.ConnectingToMultipleMongodbDatabases.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

@RestController("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = restaurantService.saveRestaurant(restaurant);
        return "restaurant Id : " + newRestaurant.getRestaurantId();
    }

    @GetMapping("/findById/{restaurantId}")
    public Restaurant getCustomer(@PathVariable String restaurantId) {
        return restaurantService.getRestaurant(restaurantId);
    }
}
