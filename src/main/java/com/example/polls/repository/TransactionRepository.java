package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{

}
