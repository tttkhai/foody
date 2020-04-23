package com.foody.controller;

import com.foody.service.RestaurantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantTypeController {
    @Autowired
    private RestaurantTypeService restaurantTypeService;

    @GetMapping(value = "/restaurantTypes")
    public ResponseEntity<?> getRestaurantType() {
        return ResponseEntity.ok().body(restaurantTypeService.getRestaurantTypes());
    }

    @GetMapping(value="/restaurantType/{id}")
    public ResponseEntity<?> getType(@PathVariable int id){
        return ResponseEntity.ok().body(restaurantTypeService.getTypes(id));
    }

}
