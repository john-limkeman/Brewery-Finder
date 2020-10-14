package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Events;

@Component
public class JDBCEventsDAO implements EventsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Events> getAllEvents() {
		List<Events> allEventsList = new ArrayList<Events>();
		String sqlInsert = "SELECT * FROM events JOIN breweries ON breweries.id = events.brewery_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlInsert);

		while (results.next()) {
			Events event = mapToRowEvents(results);
			allEventsList.add(event);
		}
		// TODO Auto-generated method stub
		return allEventsList;
	}

	@Override
	public void createEvent(Long breweryId) {
		String sqlInsert = "INSERT INTO events WHERE brewery_id = ?";
		jdbcTemplate.update(sqlInsert, breweryId);
		// TODO Auto-generated method stub

	}

	@Override
	public List<Events> getEventsByBreweryId(Long breweryId) {
		List<Events> eventsByIdList = new ArrayList<Events>();
		String sqlInsert = "Select * from events where brewery_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlInsert, breweryId);
		while (results.next()) {
			Events event = mapToRowEvents(results);
			eventsByIdList.add(event);
		}

		return eventsByIdList;
	}

	@Override
	public void updateEvent(Events event) {
		// TODO Auto-generated method stub
		String sqlInsert = "UPDATE events SET ? WHERE brewery_id = ? AND event_date = ?";
		jdbcTemplate.update(sqlInsert, event.getBrewery_id(), event.getEvent_date());
	}

	@Override
	public void deleteEvent(Events event) {
		String sqlInsert = "DELETE from events WHERE brewery_id = ? AND event_date = ?";
		jdbcTemplate.update(sqlInsert, event.getBrewery_id(), event.getEvent_date());

	}

	public Events mapToRowEvents(SqlRowSet results) {
		Events event = new Events();

		event.setEvent_id(results.getLong("event_id"));
		event.setBrewery_id(results.getLong("brewery_id"));
		event.setEvent_title(results.getString("event_title"));
		event.setEvent_date(results.getString("event_date"));
		event.setDescription(results.getString("description"));
		event.setPicture(results.getString("picture"));
		try {
			event.setBrewery_name(results.getString("name"));
		}catch(Exception e) {
			
		}
		return event;
	}

}
