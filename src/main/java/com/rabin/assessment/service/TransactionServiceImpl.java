package com.rabin.assessment.service;

import com.rabin.assessment.entity.Transaction;
import com.rabin.assessment.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

   TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository=transactionRepository;
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findByDate(Date date) {
        Optional<Transaction> transactionOptional= Optional.ofNullable((Transaction) transactionRepository.findTransactionByDate(date));
        return Optional.ofNullable(transactionOptional.orElseThrow(null));
    }

    public List<Transaction> getTransactionsByMonth(int month) {
        return transactionRepository.findTransactionsByMonth(month);
    }
    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

}
