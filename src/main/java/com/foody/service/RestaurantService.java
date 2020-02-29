package com.foody.service;

import com.foody.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> allRestaurants();

    Restaurant restaurantById(int id);

    List<Restaurant> restaurantByLocation(int zip_code);


}
