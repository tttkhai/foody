package com.foody.service;

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
    public List<RestaurantType> getRestaurantTypes() {
        List<RestaurantType> restaurantTypeList= new ArrayList<>();
        restaurantTypeRepository.findAll().forEach(restaurantTypeList::add);
        return restaurantTypeList;
    }

    @Override
    public RestaurantType getTypes(int id) {
        return restaurantTypeRepository.getType(id);
    }

}
