package com.devsu.account_service.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsu.account_service.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
