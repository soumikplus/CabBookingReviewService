package com.example.ReviewServiceCabBooking.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends Review{
    @Column(nullable = false,columnDefinition = "TEXT")
    private String passengerReviewContent;

    @Column(nullable = false)
    private String passengerRating;
}
