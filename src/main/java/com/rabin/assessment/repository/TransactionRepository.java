package com.rabin.assessment.repository;
import com.rabin.assessment.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
        public Transaction findTransactionByDate(Date date);

        @Query("SELECT t FROM Transaction t WHERE MONTH(t.date) = :month")
        List<Transaction> findTransactionsByMonth(int month);

}
