package com.example.ReviewServiceCabBooking.repository;

import com.example.ReviewServiceCabBooking.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    Integer countAllByRatingIsLessThanEqual(Integer givenRating);
    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);
    List<Review> findAllByCreatedAtBefore(Date date);
}
