package com.techelevator.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.BrewerRequest;


@Component
public class JDBCBrewerRequestDAO implements BrewerRequestDAO {


@Autowired
private JdbcTemplate jdbcTemplate;


	@Override
	public void switchProcessedStatus(BrewerRequest request) {
		String sql = "UPDATE brewer_request SET processed = ? WHERE id = ?";
		jdbcTemplate.update(sql, request.isProcessed(), request.getId() );
	}


	@Override
	public void updateBrewerIdForBrewery(BrewerRequest request) {
		String sql = "Update breweries SET brewer_id = ? WHERE id = ?";
		jdbcTemplate.update(sql, request.getUserId(), request.getBreweryId() );
		
	}


	
	


}
