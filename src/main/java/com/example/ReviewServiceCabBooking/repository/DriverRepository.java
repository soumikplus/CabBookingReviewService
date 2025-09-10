package com.example.ReviewServiceCabBooking.repository;

import com.example.ReviewServiceCabBooking.model.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {

     Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

     List<Driver> findAllByIdIn(List<Long> driversIds);
}
