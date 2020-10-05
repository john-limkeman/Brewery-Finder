package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Beer;

public interface BeerDAO {
	
	public List <Beer> getAllBeer();
	public Beer getBeerById(Long id);
	public List<Beer> BeerByBrewery(Long id);
	
	

}
