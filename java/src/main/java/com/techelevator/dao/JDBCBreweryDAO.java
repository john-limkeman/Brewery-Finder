package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

@Component
public class JDBCBreweryDAO implements BreweryDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Brewery> getAllBrewerys() {
		List<Brewery> output = new ArrayList<Brewery>();
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

	@Override
	public Brewery getBreweryByBrewer(Long id) {
		String sql = "SELECT * FROM breweries WHERE brewer_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			return mapRowToBrewery(results);
		} else {
			throw new RuntimeException("No Brewery Found");
		}
	}
	@Override
	public void deleteBrewery(Long id) {
		jdbcTemplate.update("DELETE FROM breweries WHERE id = ?", id);

	}

	@Override
	public void saveBrewery(Brewery brewery) {

		jdbcTemplate.update(
				"INSERT INTO breweries (name, address, description, image, brewery_url, phone, hours, active) VALUES (?,?,?,?,?,?,?,?)",
				brewery.getName(), brewery.getAddress(), brewery.getDescription(), brewery.getImage(),
				brewery.getBrewery_url(), brewery.getPhone(), brewery.getHours(), brewery.isActive());

	}

	@Override
	public void updateBrewery(Brewery brewery, long id) {

		String sqlInsert = "UPDATE breweries SET name = ?, address = ?, description = ?, image = ?, brewery_url = ?, phone = ?, hours = ?, active = ?"
				+ " WHERE id = ?";

		jdbcTemplate.update(sqlInsert, brewery.getName(), brewery.getAddress(), brewery.getDescription(),
				brewery.getImage(), brewery.getBrewery_url(), brewery.getPhone(), brewery.getHours(),
				brewery.isActive(), id);

	}

	// maps SQL query to brewery object
	private Brewery mapRowToBrewery(SqlRowSet results) {
		Brewery brewery = new Brewery();
		brewery.setId(results.getLong("id"));
		brewery.setName(results.getString("name"));
		brewery.setAddress(results.getString("address"));
		brewery.setDescription(results.getString("description"));
		brewery.setBrewerId(results.getLong("brewer_id"));
		brewery.setBrewery_url(results.getString("brewery_url"));
		brewery.setPhone(results.getLong("phone"));
		brewery.setHours(results.getString("hours"));
		brewery.setActive(results.getBoolean("active"));
		brewery.setImage(results.getString("image"));
		return brewery;
	}


}
