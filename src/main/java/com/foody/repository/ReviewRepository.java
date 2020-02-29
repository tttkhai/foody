package com.foody.repository;

import com.foody.entity.City;
import com.foody.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("SELECT * from review where restaurant_id:=restaurant_id")
    List<Review> reviewsByRestaurant(int restaurant_id);

}
