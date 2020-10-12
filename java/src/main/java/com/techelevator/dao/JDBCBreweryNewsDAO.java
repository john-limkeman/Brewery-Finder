package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.BrewerRequest;
import com.techelevator.model.BreweryNews;

@Component
public class JDBCBreweryNewsDAO implements BreweryNewsDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BreweryNews> getAllNews() {
		List<BreweryNews> allNews = new ArrayList<>();
		String sqlInsert = "SELECT * from brewery_news " + 
				"JOIN breweries ON brewery_news.breweryId = breweries.id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlInsert);
		while(results.next()) {
			BreweryNews news = mapRowToBreweryNews(results);
			allNews.add(news);
		}
		return allNews;
	}

	@Override
	public List<BreweryNews> getNewsByBreweryId(Long breweryId) {
		List<BreweryNews> newsList = new ArrayList<>();
		String sqlInsert = "Select * from brewery_news WHERE breweryId = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlInsert, breweryId); 
		
		while(results.next()) {
			BreweryNews news = mapRowToBreweryNews(results);
			
			newsList.add(news);
		}
		// TODO Auto-generated method stub
		return newsList;
	}

	@Override
	public void deleteNews(Long newsId) {
		String sqlInsert = "DELETE * FROM brewery_news WHERE newsId = ?";
		jdbcTemplate.update(sqlInsert, newsId);// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNews(BreweryNews news) {
		
		
	}

	@Override
	public void addNews(BreweryNews news) {
		String sql = "INSERT INTO brewery_news (breweryId, newsTitle, body) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, news.getBreweryId(), news.getNewstitle(), news.getBody());
	}
		
	
	
	public BreweryNews mapRowToBreweryNews(SqlRowSet results) {
		BreweryNews news = new BreweryNews();
		news.setNewsId(results.getLong("newsId"));
		news.setBreweryId(results.getLong("breweryId"));
		news.setNewstitle(results.getString("newsTitle"));
		news.setBody(results.getString("body"));
		news.setNewsImageUrl(results.getString("newsImageUrl"));
		try {
			news.setBreweryName(results.getString("name"));
		} catch (Exception e){
			
		}
		return news;
	}

}
