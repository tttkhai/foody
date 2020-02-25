package com.foody.repository;

import com.foody.entity.City;
import com.foody.entity.Restaurant;
import com.foody.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
