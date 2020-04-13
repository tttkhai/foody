package com.foody.service;

import com.foody.entity.FoodType;
import com.foody.entity.Restaurant;
import com.foody.entity.RestaurantType;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface RestaurantService {
    List<Restaurant> allRestaurants();

    Restaurant restaurantById(int id);

    List<Restaurant> restaurantByLocation(int zip_code);

    Restaurant addRestaurant(int user_id, Restaurant restaurant) throws IOException, JSONException;

    List<Restaurant> getRestaurantListBySearch(double lat, double lng, List<FoodType> food_types, List<RestaurantType> res_types, double distance);

    double[] getLocation_object(String url) throws IOException, JSONException;

}
