package com.foody.service;

import com.foody.entity.Restaurant;
import com.foody.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public List<Restaurant> allRestaurants() {
        List<Restaurant> restaurantList= new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurantList::add);
        return restaurantList;
    }

    @Override
    public Restaurant restaurantById(int id) {
        return restaurantRepository.findById(id).map(res->{
            return res;
        }).orElseThrow(()->new ResourceNotFoundException("Restaurant Id  " + id + " not found"));
    }

    @Override
    public List<Restaurant> restaurantByLocation(int zip_code) {
        return restaurantRepository.restaurantByLocation(zip_code);
    }
}
