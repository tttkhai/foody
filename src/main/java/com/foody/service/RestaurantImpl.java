package com.foody.service;

import com.foody.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantImpl {

    @Autowired
    private RestaurantRepository restaurantRepository;


}
