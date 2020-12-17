package com.foody.repository;

import com.foody.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query(value="SELECT * from restaurant r where SUBSTRING_INDEX(r.address,' ' ,-1)=?1", nativeQuery = true)
    List<Restaurant> restaurantByLocation(int zip_code);

    @Query(value="Select * from restaurant as r "+
            "join restaurant_restaurant_type as rrt on rrt.restaurant_id=r.id "+
            "join restaurant_food_type as rft on rft.restaurant_id=r.id "+
            "where (10193.6* ACOS(LEAST(COS(RADIANS(r.lat))*" +
            "COS(RADIANS(:lat)) * COS(RADIANS(r.lng - (:lng)))+" +
            "SIN(RADIANS(r.lat)) * SIN(RADIANS(:lat)),1.0))) <=:distance " +
            "and rrt.type_id IN (:res_types) " +
            "AND rft.food_id IN (:food_types)" , nativeQuery = true)
    List<Restaurant> getRestaurantResults(double lat, double lng, @Param("food_types") List<Integer> food_types,  @Param("res_types") List<Integer> res_types, double distance) ;


    @Query(value="SELECT * FROM restaurant r, restaurant_food_type ft where r.restaurant_types_id IN (:res_types) " +
        "AND (ft.food_id IN (:food_types) AND ft.restaurant_id=r.id) " +
        "AND (Select ST_Distance_Sphere(point(r.lat, r.lng),point(:lat, :lng))/1609.34) <= (:distance)"
    , nativeQuery = true)
    List<Restaurant> getRestaurantListBySearch(double lat, double lng, @Param("food_types") List<Integer> food_types,  @Param("res_types") List<Integer> res_types, double distance) ;
}
