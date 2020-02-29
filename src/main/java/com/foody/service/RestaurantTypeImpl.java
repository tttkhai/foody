package com.foody.service;

import com.foody.repository.RestaurantTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTypeImpl {

    @Autowired
    private RestaurantTypeRepository restaurantTypeRepository;


}
