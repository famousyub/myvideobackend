package com.example.polls.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.polls.model.Stade;
import com.example.polls.repository.StadeRepository;


@RestController
@RequestMapping("/api/v1")
public class StadeController {
	
	 @Autowired
	    private StadeRepository instructorRepository;


	    @GetMapping("/stades")
	    public List<Stade>  getInstructors() {
	        return instructorRepository.findAll();
	    }

	    @GetMapping("/instructors/{id}")
	    public ResponseEntity <Stade> getInstructorById(
	        @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
	    	Stade user = instructorRepository.findById(instructorId)
	            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
	        return ResponseEntity.ok().body(user);
	    }

	    @PostMapping("/stades")
	    public Stade createUser(@Valid @RequestBody Stade instructor) {
	        return instructorRepository.save(instructor);
	    }

	    @PutMapping("/stades/{id}")
	    public ResponseEntity < Stade > updateUser(
	        @PathVariable(value = "id") Long instructorId,
	        @Valid @RequestBody Stade userDetails) throws ResourceNotFoundException {
	    	Stade user = instructorRepository.findById(instructorId)
	            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
	        user.setEmail(userDetails.getEmail());
	        final Stade updatedUser = instructorRepository.save(user);
	        return ResponseEntity.ok(updatedUser);
	    }

	    @DeleteMapping("/instructors/{id}")
	    public Map < String, Boolean > deleteUser(
	        @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
	    	Stade instructor = instructorRepository.findById(instructorId)
	            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));

	        instructorRepository.delete(instructor);
	        Map < String, Boolean > response = new HashMap<>() ;
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
