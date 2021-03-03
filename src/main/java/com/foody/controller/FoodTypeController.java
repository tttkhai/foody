package com.foody.controller;

import com.foody.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodTypeController {
    @Autowired
    private FoodTypeService foodTypeService;

    @GetMapping(value = "/foodTypes")
    public ResponseEntity<?> getAllFoodType(){
        try{
            return ResponseEntity.ok().body(foodTypeService.getAllFoodTypes());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+e);
        }
    }

    @GetMapping(value = "/foodType/{id}")
    public ResponseEntity<?> getAllFoodType(@PathVariable int id){
        try {
            return ResponseEntity.ok().body(foodTypeService.getFoodType(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+e);
        }
    }

}
