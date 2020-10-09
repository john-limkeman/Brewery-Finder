package com.techelevator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.BrewerRequest;


@Component
public class JDBCBrewerRequestDAO implements BrewerRequestDAO {


@Autowired
private JdbcTemplate jdbcTemplate;


	@Override
	public void switchProcessedStatus(BrewerRequest request, long userId) {
		String sql = "UPDATE brewer_request SET processed = ? WHERE user_id = ? AND breweryid = ?";
		jdbcTemplate.update(sql, request.isProcessed(), userId, request.getBreweryId());
	}

}
