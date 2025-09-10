package com.example.ReviewServiceCabBooking.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "reviews")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

    @Column(length = 1000)
    private String content;


    @Column(nullable = false)

    private Double rating;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id",nullable = false)
    @JsonBackReference
    private Booking booking;


    @Override
    public String toString(){
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt;
    }

}
