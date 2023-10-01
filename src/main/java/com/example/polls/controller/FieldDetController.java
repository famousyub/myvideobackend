package com.example.polls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.Field;
import com.example.polls.model.FieldDetail;
import com.example.polls.repository.FieldRepository;
import com.example.polls.repository.FielddetailRepository;

@RestController
@RequestMapping("/api/v0")
@CrossOrigin("*")
public class FieldDetController {
	
	@Autowired
	private FielddetailRepository fielddetailRepository;
	
	@Autowired
	private FieldRepository  fieldRepository;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> createfield(@RequestBody FiledRequest filed)
	{
		
		
		Field f = new Field();
		FieldDetail fd = new FieldDetail();
		f.setImageUrl(filed.getImageUrl());
		
		f.setPathurl(filed.getPathurl());
		f.setPricehour(filed.getPricehour());
		f.setTitle(filed.getTitle());
		
		
		fd.setAddress(filed.getAddress());
		fd.setDescription(filed.getDescription());
		fd.setEndProgram(filed.getEndProgram());
		fd.setStartProgram(filed.getStartProgram());
		fd.setField(f);
		fielddetailRepository.save(fd);
		f.setDetail(fd);
		fieldRepository.save(f);
		
		return ResponseEntity.ok().body(filed);
		
		
		
	}

}
