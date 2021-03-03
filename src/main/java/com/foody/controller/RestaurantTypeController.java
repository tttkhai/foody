package com.foody.controller;

import com.foody.service.RestaurantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try{
            return ResponseEntity.ok().body(restaurantTypeService.getRestaurantTypes());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+e);
        }
    }

    @GetMapping(value="/restaurantType/{id}")
    public ResponseEntity<?> getType(@PathVariable int id){
        try {
            return ResponseEntity.ok().body(restaurantTypeService.getTypes(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+e);
        }
    }

}
