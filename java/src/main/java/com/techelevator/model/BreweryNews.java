package com.techelevator.model;

public class BreweryNews {

	private Long newsId;
	private Long breweryId;
	private String newstitle;
	private String body;
	
	
	public Long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public Long getBreweryId() {
		return breweryId;
	}
	public void setBreweryId(Long breweryId) {
		this.breweryId = breweryId;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	
	
	
}
