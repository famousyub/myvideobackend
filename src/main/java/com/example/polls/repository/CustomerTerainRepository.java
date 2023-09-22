package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Customer;


@Repository
public interface CustomerTerainRepository extends JpaRepository<Customer, Long> {
}
