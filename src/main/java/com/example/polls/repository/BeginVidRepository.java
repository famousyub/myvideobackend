package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.BeginVid;

@Repository
public interface BeginVidRepository extends JpaRepository<BeginVid, Long> {

}
