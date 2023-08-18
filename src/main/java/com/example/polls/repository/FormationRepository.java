package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Formation;


@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

}
