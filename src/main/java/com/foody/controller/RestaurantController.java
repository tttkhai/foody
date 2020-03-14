package com.foody.controller;

import com.foody.entity.Restaurant;
import com.foody.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/restaurants")
    public ResponseEntity<?> getAllRestaurants(@PathVariable int id) {
        List<Restaurant> restaurantList = restaurantService.allRestaurants();
        return ResponseEntity.ok().body(restaurantList);
    }

    @GetMapping(value = "/restaurant/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable int id) {
        Restaurant restaurant = restaurantService.restaurantById(id);
        return ResponseEntity.ok().body(restaurant);
    }

    @GetMapping(value = "/results")
    public ResponseEntity<?> getRestaurantByLocation(@RequestBody int zip_code) {
        List<Restaurant> restaurants = restaurantService.restaurantByLocation(zip_code);
        return ResponseEntity.ok().body(restaurants);
    }


}
