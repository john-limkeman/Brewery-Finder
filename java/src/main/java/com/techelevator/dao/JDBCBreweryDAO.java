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
	
	
	@Override
	public List<Brewery> getAllBrewerys() {
		List <Brewery> output = new ArrayList <Brewery>();
		String sql = "SELECT * FROM breweries";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			 output.add(mapRowToBrewery(results));
		} 
		return output;
	}

	@Override
	public Brewery getBreweryById(long id) {
		String sql = "SELECT * FROM breweries WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			 return mapRowToBrewery(results);
		} else {
			throw new RuntimeException("No brewery found");
		}
	}

	// maps SQL query to brewery object 
	private Brewery mapRowToBrewery(SqlRowSet results) {
		Brewery brewery = new Brewery();
		brewery.setId(results.getLong("id"));
		brewery.setName(results.getString("name"));
		brewery.setAddress(results.getString("address"));
		brewery.setDiscription(results.getString("description"));
		brewery.setBrewerId(results.getLong("brewer_id"));
		brewery.setUrl(results.getString("brewery_url"));
		brewery.setPhoneNumber(results.getString("phone"));
		brewery.setHours(results.getString("hours"));
		brewery.setActive(results.getBoolean("active"));
		return brewery;
	}
	
}
