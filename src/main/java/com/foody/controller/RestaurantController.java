package com.foody.controller;

import com.foody.entity.FoodType;
import com.foody.entity.Restaurant;
import com.foody.entity.RestaurantType;
import com.foody.service.RestaurantService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/addRestaurant")
//    public ResponseEntity<?> createRestaurant(@PathVariable int user_id, @RequestBody Restaurant restaurant) throws IOException, JSONException {
//    public ResponseEntity<?> createRestaurant(@Valid @RequestBody Restaurant restaurant) throws IOException, JSONException {
    public ResponseEntity<?> createRestaurant(@Valid @RequestBody Map<String, Object> payload ) throws IOException, JSONException {
        System.out.println("this is payload: "+payload.toString());
        restaurantService.addRestaurant(payload);
        return ResponseEntity.ok().build();
    }

}
