package com.example.polls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.StadeZone;
import com.example.polls.repository.StadeRepository;
import com.example.polls.repository.StadeZoneRepository;


@RequestMapping("/api/v1")
@RestController
@CrossOrigin("*")
public class StadeClientController {
	
	 @Autowired
	    private StadeZoneRepository instructorRepository;
	 
	 
	 @GetMapping("/stadescleints")
	 public ResponseEntity<?> getaalstades(){
		 
		  List<StadeZone>  stadezones =  instructorRepository.findAll();
		  
		  return ResponseEntity.ok().body(stadezones);
		  
	 }
	 
	 @GetMapping("/stadescleints/{id}")
	 public ResponseEntity<?> stadezonzone(@PathVariable("id") Long id)
	 {
		 StadeZone satdef = instructorRepository.findById(id).get();
		 return ResponseEntity.ok().body(satdef);
	 }
	 
	 


}
