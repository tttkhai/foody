package com.foody.service;

import com.foody.entity.Restaurant;
import com.foody.entity.User;
import com.foody.repository.RestaurantRepository;
import com.foody.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;
    private UserService userService;

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

    @Override
    public Restaurant addRestaurant(int user_id, Restaurant restaurant) {
        User user=userService.getUser(user_id);
        if(user!=null) {
           if (user.getRoles().stream().filter(role -> {return role.getName().equals("admin");})==null) {
               return restaurantRepository.save(restaurant);
           }
       }
        return null;
    }

}
