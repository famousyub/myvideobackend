package com.example.polls.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.polls.model.Person;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
