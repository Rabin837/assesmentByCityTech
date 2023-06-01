package com.rabin.assessment.controller;

import com.rabin.assessment.entity.Transaction;
import com.rabin.assessment.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class TransactionController {
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction")
    ResponseEntity<List<Transaction>> findAll(){
        List<Transaction> transactions=transactionService.findAll();
        return new  ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @GetMapping("/transaction/{date}")
    public Optional<Transaction> findById(@PathVariable("date") String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date requiredDate = dateFormat.parse(date);
        return transactionService.findByDate(requiredDate);
    }

    @GetMapping("/transaction/month/{month}")
    public ResponseEntity<List<Transaction>> getTransactionsByMonth(@PathVariable int month) {
        List<Transaction> transactions = transactionService.getTransactionsByMonth(month);
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/transaction")
    public void save(@RequestBody Transaction transaction){
        transactionService.save(transaction);
    }
}
