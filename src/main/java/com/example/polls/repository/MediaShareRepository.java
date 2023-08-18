package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Mediashare;


@Repository
public interface MediaShareRepository  extends JpaRepository<Mediashare, Long>{

}
