package com.example.ReviewServiceCabBooking.repository;

import com.example.ReviewServiceCabBooking.model.Driver;
import com.example.ReviewServiceCabBooking.projection.DriverView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {

     Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

//    @Query(nativeQuery = true,value = "SELECT * FROM Driver WHERE id =:id and license_number =:license_no")
//    Optional<Driver>rawFindByIdAndLicenseNumber(Long id,String license_no);
@Query(nativeQuery = true,value = "SELECT d.name as name, d.license_Number as licenseNumber  FROM Driver d WHERE d.id = :id")
    DriverView findDriverInfoByIdNative(Long id);
}
