package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.BeerDAO;
import com.techelevator.model.Beer;

@RestController
@CrossOrigin
public class BeerController {
	
	@Autowired
	BeerDAO dao;
	
	@RequestMapping(path="/beer", method=RequestMethod.GET)
	public List<Beer> getAllBeer() {
		return dao.getAllBeer();
	}
	
	@RequestMapping(path="/beer/{id}", method=RequestMethod.GET)
	public Beer getBeerById(Long id) {
		return dao.getBeerById(id);
	}
	

}
