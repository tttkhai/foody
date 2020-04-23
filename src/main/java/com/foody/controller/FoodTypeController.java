package com.foody.controller;

import com.foody.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodTypeController {
    @Autowired
    private FoodTypeService foodTypeService;

    @GetMapping(value = "/getFoodTypes")
    public ResponseEntity<?> getAllFoodType(){
        return ResponseEntity.ok().body(foodTypeService.getAllFoodTypes());
    }

    @GetMapping(value = "/getFoodType/{id}")
    public ResponseEntity<?> getAllFoodType(@PathVariable int id){
        return ResponseEntity.ok().body(foodTypeService.getFoodType(id));
    }

}
