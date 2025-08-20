package com.devsu.account_service.repository.transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsu.account_service.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findTopByAccountNumberOrderByDateDesc(Long accountNumber);

    List<Transaction> findByAccountNumberInAndDateBetween(
        List<Long> accountNumbers, 
        LocalDateTime startDate, 
        LocalDateTime endDate
    );

}
