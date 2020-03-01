package com.foody.controller;

import com.foody.entity.City;
import com.foody.service.CountryImpl;
import com.foody.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/country")
    public ResponseEntity<?> getAllCountry() {
        return ResponseEntity.ok().body(countryService.getAllCountry());
    }
    @GetMapping(value = "/hello")
    public String health() {
        return "Hello";
    }
}
