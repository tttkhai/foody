package com.foody.repository;

import com.foody.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value="SELECT * from review r where r.restaurant_id=?1", nativeQuery = true)
    List<Review> reviewsByRestaurant(int restaurant_id);

    @Query(value="call AddReview(:cleanliness, :customer_service, :deliver, :taste, :comment, :restaurant_id, :user_id)"
           , nativeQuery = true)
    Review addReview(int cleanliness, int customer_service, int deliver, int taste, String comment, int restaurant_id, int user_id);
}
