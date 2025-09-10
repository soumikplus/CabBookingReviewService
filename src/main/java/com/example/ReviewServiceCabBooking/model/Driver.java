package com.example.ReviewServiceCabBooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    @OneToMany(mappedBy = "driver",cascade ={CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Booking> bookings;
}
