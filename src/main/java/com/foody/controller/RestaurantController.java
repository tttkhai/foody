package com.foody.controller;

import com.foody.entity.FoodType;
import com.foody.entity.Restaurant;
import com.foody.entity.RestaurantType;
import com.foody.service.RestaurantService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "/newRestaurant")
    public ResponseEntity<?> createRestaurant(@Valid @RequestBody Map<String, Object> payload) throws IOException, JSONException {
        restaurantService.addRestaurant(payload);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/restaurantList")
    public ResponseEntity<?> getRestaurantListBySearch(@Valid @RequestBody Map<String, Object> payload) throws JSONException {
        List<Restaurant> restaurantList=restaurantService.getRestaurantListBySearch(payload);
        return ResponseEntity.ok().body(restaurantList);
    }

}
