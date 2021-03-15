package com.cg.customermgmt.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.customermgmt.customer.entities.Account;

public interface IAccountRepository extends JpaRepository<Account, Long>{

}
