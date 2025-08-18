package com.devsu.account_service.repository.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.account_service.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
