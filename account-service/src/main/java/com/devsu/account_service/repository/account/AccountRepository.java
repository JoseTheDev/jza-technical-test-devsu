package com.devsu.account_service.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.account_service.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
