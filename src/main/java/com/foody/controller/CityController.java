package com.foody.controller;

import com.foody.entity.City;
import com.foody.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/city/{state_id}")
    public ResponseEntity<?> getCityByState(@PathVariable int state_id) {
        List<City> cities = cityService.getCityByState(state_id);
        return ResponseEntity.ok().body(cities);
    }

}
