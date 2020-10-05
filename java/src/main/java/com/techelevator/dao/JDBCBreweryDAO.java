package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Brewery;

@Component
public class JDBCBreweryDAO implements BreweryDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	// TODO make sure table is named appropriately for this method
	@Override
	public List<Brewery> getAllBrewerys() {
		List <Brewery> output = new ArrayList <Brewery>();
		String sql = "SELECT * FROM brewery";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			 output.add(mapRowToBrewery(results));
		} 
		return output;
	}

	// TODO make sure table and column are named appropriately for this method
	@Override
	public Brewery getBreweryById(long id) {
		String sql = "SELECT * FROM brewery WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			 return mapRowToBrewery(results);
		} else {
			throw new RuntimeException("No brewery found");
		}
	}

	// maps SQL query to brewery object 
	// TODO add column names in the ""
	private Brewery mapRowToBrewery(SqlRowSet results) {
		Brewery brewery = new Brewery();
		brewery.setId(results.getLong(""));
		brewery.setName(results.getString(""));
		brewery.setAddress(results.getString(""));
		brewery.setDiscription(results.getString(""));
		brewery.setBrewerId(results.getLong(""));
		brewery.setUrl(results.getString(""));
		brewery.setPhoneNumber(results.getString(""));
		brewery.setHours(results.getString(""));
		brewery.setActive(results.getBoolean(""));
		return brewery;
	}
	
}
