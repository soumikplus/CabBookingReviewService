package com.example.ReviewServiceCabBooking.repository;

import com.example.ReviewServiceCabBooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository <Booking,Long>{
}
