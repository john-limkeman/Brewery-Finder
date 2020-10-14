package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

@Component
public class JDBCBeerDAO implements BeerDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JDBCBeerDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Beer> getAllBeer() {

		List<Beer> allBeer = new ArrayList<>();
		String sqlSelectAllBeer = "SELECT * FROM beers";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAllBeer);

		while (result.next()) {
			allBeer.add(mapRowToBeer(result));
		}

		return allBeer;

	}

	@Override
	public List<Beer> BeerByBrewery(Long id) {
		List<Beer> brewBeers = new ArrayList<>();
		String sqlBrewBeer = "SELECT * FROM beers WHERE brewery_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlBrewBeer, id);

		while (result.next()) {
			brewBeers.add(mapRowToBeer(result));
		}
		return brewBeers;
	}

	@Override
	public Beer getBeerById(Long id) {

		Beer beer = new Beer();
		String sqlSelectBeerByName = "SELECT * FROM beers where beer_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectBeerByName, id);

		if (result.next()) {
			beer = mapRowToBeer(result);
		}
		

		
		return beer;
	}

	@Override
	public void deleteBeer(Long id) {
		jdbcTemplate.update("DELETE FROM beers WHERE beer_id = ?", id);

	}

	@Override
	public void saveBeer(Beer beer) {
		jdbcTemplate.update(
				"INSERT INTO beers (beer_name, brewery_id, beer_type, description, picture, abv, ibu, available) VALUES (?,?,?,?,?,?,?,?)",
				beer.getName(), beer.getBreweryId(), beer.getType(), beer.getDescription(), beer.getImgUrl(),
				beer.getAbv(), beer.getIbu(), beer.isCurrent());

	}

	@Override
	public void updateBeer(Beer beer, long id) {

		String sql = "UPDATE beers SET beer_name = ?, beer_type = ?, description = ?, picture = ?, abv = ?, ibu = ?, available = ? WHERE beer_id = ?";

		jdbcTemplate.update(sql, beer.getName(), beer.getType(), beer.getDescription(), beer.getImgUrl(), beer.getAbv(),
				beer.getIbu(), beer.isCurrent(), id);

	}
	
	@Override
	public void updateRating(Long id) {
		String sql = "SELECT AVG(rating) FROM review WHERE beerId = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
		Double rounded = 0.0;
		while (result.next()) {
		Double average = result.getDouble("avg");
		rounded = DoubleRounder.round(average, 1);
		}
		String update = "UPDATE beers SET rating = ? WHERE beer_id = ?";
		jdbcTemplate.update(update, rounded, id);
		
	}

	private Beer mapRowToBeer(SqlRowSet row) {

		Beer beer = new Beer();

		beer.setId(row.getLong("beer_id"));
		beer.setName(row.getString("beer_name"));
		beer.setAbv(row.getDouble("abv"));
		beer.setIbu(row.getDouble("ibu"));
		beer.setBreweryId(row.getLong("brewery_id"));
		beer.setType(row.getString("beer_type"));
		beer.setDescription(row.getString("description"));
		beer.setRating(row.getDouble("rating"));
		beer.setCurrent(row.getBoolean("available"));
		beer.setImgUrl(row.getString("picture"));

		return beer;

	}


}
