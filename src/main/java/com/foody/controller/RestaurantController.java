package com.foody.controller;

import com.foody.service.RestaurantImpl;
import com.foody.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RestaurantController {
    @Autowired
    private RestaurantImpl restaurantImpl;
}
