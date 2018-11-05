package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.SalesOrder;

@Repository
public interface CreateOrderRepository extends JpaRepository<SalesOrder, Long>{

}
