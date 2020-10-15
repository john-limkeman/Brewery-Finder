package com.techelevator.dao;

import java.awt.Event;
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
		return allEventsList;
	}

	@Override
	public void createEvent(Events event) {
		String sqlInsert = "INSERT INTO events (brewery_id, event_title, event_date, description, picture) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsert, event.getBrewery_id(), event.getEvent_title(), event.getEvent_date(), event.getDescription(), event.getPicture());
	

	}

	@Override
	public List<Events> getEventsByBreweryId(Long breweryId) {
		List<Events> eventsByIdList = new ArrayList<Events>();
		String sqlInsert = "Select * from events JOIN breweries ON breweries.id = events.brewery_id where breweries.id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlInsert, breweryId);
		while (results.next()) {
			Events event = mapToRowEvents(results);
			eventsByIdList.add(event);
		}

		return eventsByIdList;
	}

	@Override
	public Events getEventByEventId(Long id) {
		Events event = new Events();
		String sql = "SELECT * from events WHERE event_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		while (results.next()) {
			event = mapToRowEvents(results);
		}
		return event;
	}
	@Override
	public void updateEvent(Events event) {
		String sqlInsert = "UPDATE events SET event_title = ?, event_date = ?, description = ?, picture = ? WHERE event_id = ?";
		jdbcTemplate.update(sqlInsert, event.getEvent_title(), event.getEvent_date(), event.getDescription(), event.getPicture(), event.getEvent_id());
	}

	@Override
	public void deleteEvent(Long id) {
		String sqlInsert = "DELETE from events WHERE event_id = ?";
		jdbcTemplate.update(sqlInsert, id);

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
