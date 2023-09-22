package com.example.polls.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.model.Field;
import com.example.polls.repository.FieldRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldService {

    @Autowired
    private FieldRepository fieldRepository;


 public     List<Field> getAllFilesd()
    {


          return fieldRepository.findAll();



    }
}
