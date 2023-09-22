package com.example.polls.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.PaymentTerrain;

@Repository
public interface  PaymentRepository  extends JpaRepository<PaymentTerrain, Long> {
}
