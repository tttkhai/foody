package com.foody.service;

import com.foody.entity.Country;
import com.foody.entity.RestaurantType;
import com.foody.repository.RestaurantTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantTypeImpl implements RestaurantTypeService{

    @Autowired
    private RestaurantTypeRepository restaurantTypeRepository;

    @Override
    public List<RestaurantType> getRestaurantType() {
        List<RestaurantType> restaurantTypeList= new ArrayList<>();
        restaurantTypeRepository.findAll().forEach(restaurantTypeList::add);
        return restaurantTypeList;
    }


}
