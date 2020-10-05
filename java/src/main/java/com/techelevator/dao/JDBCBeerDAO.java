package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Beer;



@Component
public class JDBCBeerDAO implements BeerDAO {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Beer> getAllBeer() {
		
		List<Beer> allBeer = new ArrayList<>();
		String sqlSelectAllBeer = "SELECT * FROM beers";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAllBeer);
		
		while(result.next()) {
			allBeer.add(mapRowToBeer(result));
		}
		
		return allBeer;
		
		
	}

	@Override
	public Beer getBeerById(Long id) {
			
		Beer beer = new Beer();
		String sqlSelectBeerByName = "SELECT * FROM beers where beer_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectBeerByName,id);
		
		if(result.next()) {
			beer = mapRowToBeer(result);
		}
		
		return beer;
	}
	
	private Beer mapRowToBeer(SqlRowSet row) {
		
		Beer beer = new Beer();
		
		beer.setId(row.getLong("beer_id"));
		beer.setName(row.getString("beer_name"));
		beer.setAbv(row.getInt("abv"));
		beer.setIbu(row.getInt("ibu"));
		beer.setBreweryId(row.getLong("brewery_id"));
		beer.setType(row.getString(""));
		beer.setDescription(row.getString("description"));
		beer.setRating(row.getInt("rating"));
		beer.setCurrent(row.getBoolean("available"));
	
		
		return beer;
		
	}

}
