package com.foody.service;

import com.foody.entity.RestaurantType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantTypeService {
    List<RestaurantType> getRestaurantTypes();
    RestaurantType getTypes(int id);


}
