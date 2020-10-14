package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.EventsDAO;
import com.techelevator.model.Events;

@CrossOrigin
@RestController
public class EventsController {

	@Autowired
	private EventsDAO dao;

	@RequestMapping(path = "/breweryEvents/{id}", method = RequestMethod.GET)
	public List<Events> eventsByBreweryId(@PathVariable long id) {
		return dao.getEventsByBreweryId(id);
	}

	@RequestMapping(path = "/deleteEvent", method = RequestMethod.DELETE)
	public void deleteEventsByBreweryId(@RequestBody Events event) {
		dao.deleteEvent(event);
	}

	@RequestMapping(path = "/newEvent", method = RequestMethod.POST)
	public void createEvent(@RequestBody Events event) {
		dao.createEvent(event);
	}

	@RequestMapping(path = "/updateEvent", method = RequestMethod.PUT)
	public void updateEvent(@RequestBody Events event) {
		dao.updateEvent(event);
	}
	
	@RequestMapping(path ="/events", method=RequestMethod.GET)
	public List<Events> getAllEvents(){
		
		List<Events> allEvents = dao.getAllEvents();
		
		return allEvents;
	}

}
