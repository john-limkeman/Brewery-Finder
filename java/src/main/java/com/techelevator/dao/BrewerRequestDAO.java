package com.techelevator.dao;

import com.techelevator.model.BrewerRequest;

public interface BrewerRequestDAO {

	public void switchProcessedStatus(BrewerRequest request, long userId);
	
	
}
