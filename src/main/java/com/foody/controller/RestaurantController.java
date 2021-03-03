package com.foody.controller;

import com.foody.entity.Restaurant;
import com.foody.service.RestaurantService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/restaurants")
    public ResponseEntity<?> getAllRestaurants(@PathVariable int id) {
        try{
            List<Restaurant> restaurantList = restaurantService.allRestaurants();
            return ResponseEntity.ok().body(restaurantList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+e);
        }

    }

    @GetMapping(value = "/restaurant/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable int id) {
        try{
            Restaurant restaurant = restaurantService.restaurantById(id);
            return ResponseEntity.ok().body(restaurant);
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+e);
        }
    }

    @GetMapping(value = "/results")
    public ResponseEntity<?> getRestaurantByLocation(@RequestBody int zip_code) {
        try {
            List<Restaurant> restaurants = restaurantService.restaurantByLocation(zip_code);
            return ResponseEntity.ok().body(restaurants);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+e);
        }
    }

    @PostMapping(value = "/newRestaurant")
    public ResponseEntity<?> createRestaurant(@Valid @RequestBody Map<String, Object> payload) throws IOException, JSONException {
        try {
            restaurantService.addRestaurant(payload);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+e);
        }
    }

    @PostMapping(value = "/search/restaurantList")
    public ResponseEntity<?> getRestaurantListBySearch(@Valid @RequestBody Map<String, Object> payload) throws JSONException {
        try {
            List<Restaurant.SearchRestaurantInterface> restaurantList=restaurantService.getRestaurantListBySearch(payload);
            return ResponseEntity.ok().body(restaurantList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+e);
        }
    }

}
