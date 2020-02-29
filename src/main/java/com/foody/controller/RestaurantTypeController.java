package com.foody.controller;

import com.foody.service.RestaurantTypeImpl;
import com.foody.service.RestaurantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RestaurantTypeController {
    @Autowired
    private RestaurantTypeImpl restaurantTypeImpl;

}
