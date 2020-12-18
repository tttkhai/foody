package com.foody.service;

import com.foody.entity.FoodType;
import com.foody.entity.Restaurant;
import com.foody.entity.RestaurantType;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface RestaurantService {
    List<Restaurant> allRestaurants();

    Restaurant restaurantById(int id);

    List<Restaurant> restaurantByLocation(int zip_code);

    void addRestaurant(Map<String, Object> payload) throws IOException, JSONException;

    List<Restaurant.SearchRestaurantInterface> getRestaurantListBySearch(Map<String, Object> payload) throws JSONException;

    double[] getLocation_object(String url) throws IOException, JSONException;
}
