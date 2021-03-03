package com.foody.repository;

import com.foody.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query(value="SELECT * from restaurant r where SUBSTRING_INDEX(r.address,' ' ,-1)=?1", nativeQuery = true)
    List<Restaurant> restaurantByLocation(int zip_code);

    @Query(value="Select distinct id, address,email, name, phone_number as phoneNumber, " +
            "ROUND(10193.6* ACOS(LEAST(COS(RADIANS(r.lat))*COS(RADIANS(:lat)) * COS(RADIANS(r.lng - (:lng)))+ SIN(RADIANS(r.lat)) * SIN(RADIANS(:lat)),1.0)),2) as distance "+
            "from restaurant as r "+
            "join restaurant_restaurant_type as rrt on rrt.restaurant_id=r.id "+
            "join restaurant_food_type as rft on rft.restaurant_id=r.id "+
            "where (10193.6* ACOS(LEAST(COS(RADIANS(r.lat))*" +
            "COS(RADIANS(:lat)) * COS(RADIANS(r.lng - (:lng)))+" +
            "SIN(RADIANS(r.lat)) * SIN(RADIANS(:lat)),1.0))) <=:distance " +
            "and rrt.type_id IN (:res_types) " +
            "AND rft.food_id IN (:food_types)" , nativeQuery = true)
    List<Restaurant.SearchRestaurantInterface> getRestaurantResults(double lat, double lng, @Param("food_types") List<Integer> food_types,  @Param("res_types") List<Integer> res_types, double distance) ;
}