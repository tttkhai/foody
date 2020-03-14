package com.foody.controller;

import com.foody.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/country")
    public ResponseEntity<?> getAllCountry() {
        return ResponseEntity.ok().body(countryService.getAllCountry());
    }
}
