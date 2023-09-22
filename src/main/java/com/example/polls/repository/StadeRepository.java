package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Stade;


@Repository
public interface StadeRepository extends JpaRepository<Stade, Long>{

}
