package com.foody.service;

import com.foody.entity.City;
import com.foody.entity.RestaurantType;
import com.foody.repository.CityRepository;
import com.foody.repository.RestaurantTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantTypeService {
    List<RestaurantType> getRestaurantTypes();
    RestaurantType getTypes(int id);


}
