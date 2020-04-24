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

    @Query(value="SELECT * FROM restaurant r WHERE IN r.restaurant_types_id (:res_types)" +
            "AND r.food_types.restaurant_types_id.food_id (:food_types)" +
            "AND (Select ST_Distance_Sphere(point(r.lat, r.lng),point(?1, ?2))/1609.34) <= ?5 "
            , nativeQuery = true)
    List<Restaurant> getRestaurantListBySearch(double lat, double lng, @Param("food_types") List<Integer> food_types,  @Param("res_types") List<Integer> res_types, double distance) ;
}
