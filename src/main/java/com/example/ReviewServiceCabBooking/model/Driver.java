package com.example.ReviewServiceCabBooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor      // required by JPA
@AllArgsConstructor
@Builder
public class Driver extends BaseModel{
    private String name;


    @Column(nullable = false,unique = true)
    private String licenseNumber;

    // Driver : Booking --> one to many
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();
}
