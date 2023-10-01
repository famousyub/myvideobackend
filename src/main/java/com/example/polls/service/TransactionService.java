package com.example.polls.service;

import java.util.List;

import com.example.polls.model.Transaction;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    Long numberOfTransactions();

    List<Transaction> findAllTransactions();
}