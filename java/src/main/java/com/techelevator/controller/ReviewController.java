package com.techelevator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ReviewDAO;
import com.techelevator.model.Review;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ReviewController {

	
	@Autowired
	ReviewDAO dao;
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/new-review", method = RequestMethod.POST)
	public void addReview(@Valid @RequestBody Review review) {
		dao.addReview(review);
	}
	
	@RequestMapping(path = "/delete-review", method = RequestMethod.DELETE)
	public void deleteReview(@Valid @RequestBody Review review) {
		dao.deleteReview(review);
	}
	
	@RequestMapping(path = "/beer/{id}/reviews", method = RequestMethod.GET)
	public List<Review> reviewByBeer(@PathVariable Long id){
		return dao.getReviewsByBeer(id);
	}
	
	@RequestMapping(path = "/brewery/{id}/reviews", method = RequestMethod.GET)
	public List<Review> reviewByBrewery(@PathVariable Long id){
		return dao.getReviewsByBrewery(id);
	}
}
