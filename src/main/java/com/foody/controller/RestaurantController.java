package com.foody.controller;

import com.foody.entity.City;
import com.foody.service.RestaurantImpl;
import com.foody.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/restaurants")
    public ResponseEntity<?> getAllRestaurants(@PathVariable int state_id) {
        List<City> cities = cityService.getCityByState(state_id);
        return ResponseEntity.ok().body(cities);
    }
}
