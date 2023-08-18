package com.example.polls.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.Formation;
import com.example.polls.repository.FormationRepository;

@RestController
@RequestMapping("api/v1/cleint")
@CrossOrigin("*")
public class ClientInterfaceController {
	
	@Autowired
	private FormationRepository formationRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getForamationByid(@PathVariable("id") Long id)
	{
		
		Formation fomations = formationRepository.findById(id).get();
		return ResponseEntity.ok().body(fomations);
		
		
				
				
				
				
				
	}

}
