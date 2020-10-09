package com.techelevator.dao;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;


import com.techelevator.model.PendingBreweryRequest;

public class JDBCPendingBreweryRequestDAO implements PendingBreweryRequestDAO {

	@Override
	public List<PendingBreweryRequest> getAllRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRequest(PendingBreweryRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRequest(PendingBreweryRequest request, long id) {
		// TODO Auto-generated method stub
		
	}
	
	private PendingBreweryRequest mapRowToRequest(SqlRowSet results) {
		PendingBreweryRequest request = new PendingBreweryRequest();
		request.setId(results.getLong("id"));
		request.setUserId(results.getInt("user_id"));
		request.setName(results.getString("name"));
		request.setAddress(results.getString("address"));
		request.setDescription(results.getString("description"));
		request.setImage(results.getString("image"));
		request.setBrewery_url(results.getString("brewery_url"));
		request.setPhone(results.getLong("phone"));
		request.setHours(results.getString("hours"));
		request.setProcessed(results.getBoolean("processed"));

		return request;
	}


}
