package com.foody.repository;

import com.foody.entity.City;
import com.foody.entity.Restaurant;
import com.foody.entity.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTypeRepository extends JpaRepository<RestaurantType, Integer> {

}
