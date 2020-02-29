package com.foody.repository;

import com.foody.entity.City;
import com.foody.entity.Restaurant;
import com.foody.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query(value="SELECT * from restaurant r where SUBSTRING_INDEX(r.address,' ' ,-1)=?1", nativeQuery = true)
    List<Restaurant> restaurantByLocation(int zip_code);
}
