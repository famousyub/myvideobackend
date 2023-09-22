package com.example.polls.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.FieldDetail;

@Repository
public interface FielddetailRepository extends JpaRepository<FieldDetail, Long> {
}
