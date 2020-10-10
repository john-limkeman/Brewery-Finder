package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.BreweryNews;

public interface BreweryNewsDAO {

	public List<BreweryNews> getAllNews();
	
	public List<BreweryNews> getNewsByBreweryId(Long breweryId);
	
	public void deleteNews(BreweryNews news);
	
	public void updateNews(BreweryNews news);
	
	public void addNews(BreweryNews news);
}
