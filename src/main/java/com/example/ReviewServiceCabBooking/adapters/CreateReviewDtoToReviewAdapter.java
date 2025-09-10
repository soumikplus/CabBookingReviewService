package com.example.ReviewServiceCabBooking.adapters;

import com.example.ReviewServiceCabBooking.dtos.CreateReviewDto;
import com.example.ReviewServiceCabBooking.model.Review;

public interface CreateReviewDtoToReviewAdapter {
    public Review convertDto(CreateReviewDto createReviewDto);
}
