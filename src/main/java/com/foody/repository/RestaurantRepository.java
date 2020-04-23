package com.foody.repository;

import com.foody.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query(value="SELECT * from restaurant r where SUBSTRING_INDEX(r.address,' ' ,-1)=?1", nativeQuery = true)
    List<Restaurant> restaurantByLocation(int zip_code);

    @Query(value="SELECT * FROM restaurant r WHERE (Select ST_Distance_Sphere(point(r.lat, r.lng),point(?1, ?2))/1609.34) <= ?5 AND" +
            "WHILE (i < (SELECT JSON_LENGTH(restaurant.food_types))) DO\n" +
            "    INSERT INTO `restaurant_food_type` (restaurant_id, food_id) values (i, 1,);\n" +
            "    SET i = i+1;\n" +
            "END WHILE;" +
            "", nativeQuery = true)
    List<Restaurant> getRestaurantListBySearch(double lat, double lng, List<FoodType> food_types, List<RestaurantType> res_types, double distance) ;
}
