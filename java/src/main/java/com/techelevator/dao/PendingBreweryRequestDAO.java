package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.PendingBreweryRequest;

public interface PendingBreweryRequestDAO {
	
	public List<PendingBreweryRequest> getAllRequest();
	
	public void addRequest(PendingBreweryRequest request);
	
	public void updateBeer(PendingBreweryRequest request, long id);
	
	
	
	

}
