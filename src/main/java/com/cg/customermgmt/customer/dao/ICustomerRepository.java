package com.cg.customermgmt.customer.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.customermgmt.customer.entities.*;

public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
