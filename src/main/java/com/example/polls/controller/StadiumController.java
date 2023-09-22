package com.example.polls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.Stadium;
import com.example.polls.repository.StadiumRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StadiumController {
	
	@Autowired
	private StadiumRepository repository;
	
	@GetMapping("/v1/stadiums")
	private ResponseEntity<?> allstadium()
	{
		List<Stadium> stadiums = repository.findAll();
		return ResponseEntity.ok().body(stadiums);
	}
	
	
	@GetMapping("/v1/stadiums/{id}")
	private ResponseEntity<?> stadiumId(@PathVariable("id") Long id)
	{
		Stadium stadiums = repository.findById(id).get();
		return ResponseEntity.ok().body(stadiums);
	}
	
	

}
