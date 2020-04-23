package com.foody.service;

import com.foody.entity.FoodType;

import java.util.List;

public interface FoodTypeService {
    List<FoodType> getAllFoodTypes();
    FoodType getFoodType(int id);

}
