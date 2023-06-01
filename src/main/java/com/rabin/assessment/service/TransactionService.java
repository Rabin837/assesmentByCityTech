package com.rabin.assessment.service;

import com.rabin.assessment.entity.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface TransactionService {

    public List<Transaction> findAll();

    public Optional<Transaction> findByDate(Date date);

    public List<Transaction> getTransactionsByMonth(int month);
    public void save(Transaction transaction);

}
