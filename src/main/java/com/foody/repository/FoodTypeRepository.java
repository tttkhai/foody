package com.foody.repository;

import com.foody.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Integer> {
    @Query(value = "Select * from food_type ft where ft.id=?1", nativeQuery = true)
    FoodType getFoodType(int id);
}
