package com.techelevator.dao;

import java.awt.Event;
import java.util.List;

import com.techelevator.model.Events;

public interface EventsDAO {

	public List<Events> getAllEvents();
	
	
	public void createEvent(Long breweryId);
	
	public List<Events> getEventsByBreweryId(Long breweryId);
	
	public void updateEvent(Events event);
	
	public void deleteEvent(Events event);
	
	
	
	
	
}