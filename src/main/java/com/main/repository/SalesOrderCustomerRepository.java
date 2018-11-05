package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.CustomerSOS;

@Repository
public interface SalesOrderCustomerRepository extends JpaRepository<CustomerSOS, Long>{
	
	

}