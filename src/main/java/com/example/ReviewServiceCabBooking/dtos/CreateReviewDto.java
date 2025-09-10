package com.example.ReviewServiceCabBooking.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto {
    private String content;
    private int rating;
    private long bookingId;
}
