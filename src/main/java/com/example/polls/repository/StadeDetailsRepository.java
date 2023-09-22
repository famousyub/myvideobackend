package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.StadeDetail;

@Repository
public interface StadeDetailsRepository  extends JpaRepository<StadeDetail, Long>{

}
