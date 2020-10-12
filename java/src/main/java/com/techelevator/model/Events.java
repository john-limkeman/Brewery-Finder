package com.techelevator.model;

public class Events {

	private long brewery_id;
	private String event_date;
	private String description;
	private String picture;
	
	
	public long getBrewery_id() {
		return brewery_id;
	}
	public void setBrewery_id(long brewery_id) {
		this.brewery_id = brewery_id;
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}
