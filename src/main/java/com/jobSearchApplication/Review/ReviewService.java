package com.jobSearchApplication.Review;

import java.util.List;


public interface ReviewService {
     List<Review> getAllReviewById(Long companyId);
     boolean addReview(Long companyId,Review review);
     Review getReview(Long companyId,Long reviewId);
     
}
