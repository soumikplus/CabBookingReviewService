package com.example.ReviewServiceCabBooking.repository;

import com.example.ReviewServiceCabBooking.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {


}
