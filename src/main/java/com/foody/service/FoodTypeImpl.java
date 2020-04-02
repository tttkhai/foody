package com.foody.service;

import com.foody.entity.FoodType;
import com.foody.repository.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodTypeImpl implements FoodTypeService {

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Override
    public List<FoodType> getAllFoodType() {
        List<FoodType> food_list= new ArrayList<>();
        foodTypeRepository.findAll().forEach(food_list::add);
        return food_list;
    }
}
