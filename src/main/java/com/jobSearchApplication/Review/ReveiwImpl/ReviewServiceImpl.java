package com.jobSearchApplication.Review.ReveiwImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobSearchApplication.Review.Review;
import com.jobSearchApplication.Review.ReviewRepository;
import com.jobSearchApplication.Review.ReviewService;

import Company.Company;
import Company.CompanyService;

@Service
public class ReviewServiceImpl implements ReviewService {
    
	private final ReviewRepository reviewRepository;
	private final CompanyService companyService;
	
	
	
	
	public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
		super();
		this.reviewRepository = reviewRepository;
		this.companyService=companyService;
	}




	@Override
	public List<Review> getAllReviewById(Long companyId) {
		
		List<Review> reviews= reviewRepository.findByCompanyId(companyId);
		return reviews;
	}




	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company=companyService.getCompanyById(companyId);
		
		if(company!= null) {
			 review.setCompany(company);
			 reviewRepository.save(review);
			 return true;
		}
		return false;
	}




	@Override
	public Review getReview(Long companyId, Long reviewId) {
		List<Review> reviews=reviewRepository.findByCompanyId(companyId);
		return reviews.stream().filter(review->review.getId().equals(reviewId)).findFirst().orElse(null);
		
	}




	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
		// TODO Auto-generated method stub
		if(companyService.getCompanyById(companyId) != null) {
			updatedReview.setCompany(companyService.getCompanyById(companyId));
			updatedReview.setId(reviewId);
			reviewRepository.save(updatedReview);
			
			return true;
		}else {
			return false;
		}
		
	}




	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
				if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
				     Review review =reviewRepository.findById(reviewId).orElse(null);
				     
				     Company company=review.getCompany();
				     company.getReviews().remove(review);
				     companyService.UpdateCompany(companyId, company);
				     reviewRepository.deleteById(reviewId);
					return true;
				}else {
					return false;
				}
	}
   
}
