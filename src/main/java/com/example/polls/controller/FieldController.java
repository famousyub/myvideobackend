package com.example.polls.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.bind.annotation.*;

import com.example.polls.model.Field;
import com.example.polls.service.FieldService;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/field")
@CrossOrigin(origins = "*") // Assuming you're using localhost:4200 as your frontend
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping("/getFields")
    public ResponseEntity<?> getFields() {
        try {
            List<Field> fields = fieldService.getAllFilesd();
            return ResponseEntity.ok(fields);
        } catch (ApplicationContextException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

