package com.foody.controller;

import com.foody.service.CityImpl;
import com.foody.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {

    @Autowired
    private CityImpl cityImpl;


}
