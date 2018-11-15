package com.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.entity.CustomerSOS;

@Repository
public interface SalesOrderCustomerRepository extends JpaRepository<CustomerSOS, Long>{
	
	 @Query("select c from CustomerSOS c where c.custId = :custId")
	 public Optional<List<CustomerSOS>> findByCustId(@Param("custId") Long custId);

}