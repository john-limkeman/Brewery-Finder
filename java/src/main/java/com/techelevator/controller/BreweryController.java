package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Brewery;

@RestController
@CrossOrigin
public class BreweryController {

	@Autowired
	public BreweryDAO dao;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String test() {
		return "It worked";
	}
	
	@PreAuthorize("permitAll()")
	@RequestMapping(path = "/breweries", method = RequestMethod.GET)
	public List <Brewery> getAllBreweries() {
		return dao.getAllBrewerys();
	}
	
	@PreAuthorize("permitAll()")
	@RequestMapping(path = "/brewery/{id}", method = RequestMethod.GET)
	public Brewery getBrewery(@PathVariable long id) {
		return dao.getBreweryById(id);
	}
}