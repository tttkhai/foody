package com.foody.service;

import com.foody.repository.CityRepository;
import com.foody.repository.RestaurantTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTypeService {

    @Autowired
    private RestaurantTypeRepository restaurantTypeRepository;


}
