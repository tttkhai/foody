package com.foody.repository;

import com.foody.entity.City;
import com.foody.entity.Restaurant;
import com.foody.entity.Review;
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

    @Modifying
    @Transactional
    @Query(value="WHILE (i < (SELECT JSON_LENGTH(restaurant.food_types))) DO\n" +
            "    INSERT INTO `restaurant_food_type` (restaurant_id, food_id) values (i, 1,);\n" +
            "    SET i = i+1;\n" +
            "END WHILE;" +
            "INSERT INTO restaurant_food_type ( `restaurant_id`, `food_id`) VALUES (restaurant.id, restaurant.food_types) ", nativeQuery = true)
    void addRestaurant(Restaurant restaurant);
}
