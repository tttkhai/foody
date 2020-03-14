package com.foody.controller;

import com.foody.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping(value = "/states/{country_id}")
    public ResponseEntity<?> getStateByCountry(@PathVariable int country_id) {
        return ResponseEntity.ok().body(stateService.getStateByCountry(country_id));
    }

}
