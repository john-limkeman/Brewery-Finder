package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

public interface BeerDAO {

	public List<Beer> getAllBeer();

	public Beer getBeerById(Long id);

	public List<Beer> BeerByBrewery(Long id);

	public void deleteBeer(Long id);

	public void saveBeer(Beer beer);

	void updateBeer(Beer beer, long id);

}
