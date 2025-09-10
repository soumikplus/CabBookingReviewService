package com.example.ReviewServiceCabBooking.Service;

import com.example.ReviewServiceCabBooking.model.Review;
import com.example.ReviewServiceCabBooking.repository.ReviewRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id) {
        if(reviewRepository.existsById(id)){
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Review publishReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        return reviewRepository.findById(id)
                .map(existing->
                {
                    existing.setContent(review.getContent());
                    existing.setRating(review.getRating());
                    return reviewRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }
}
