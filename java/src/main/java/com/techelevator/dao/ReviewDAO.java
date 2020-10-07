package com.techelevator.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.model.Review;

public interface ReviewDAO {

	public void addReview(Review review);
	
	public void deleteReview(Review review);
	
	public List<Review> getReviewsByBeer(Long BeerId);
	
	public List<Review> getReviewsByBrewery(Long BreweryId);
	
	
}
