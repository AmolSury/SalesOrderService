package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.SalesOrder;
import com.main.services.SalesOrderServiceImpl;

@RestController
public class SalesOrderServiceController {
	
	private SalesOrderServiceImpl salesOrderServiceImpl;
	
	@PostMapping(value = "/create")
	public ResponseEntity<Long> createSalesOrder(@RequestBody SalesOrder salesOrder) {
		
		Long orderId = getSalesOrderServiceImpl().createSalesOrder(salesOrder);	
		return new ResponseEntity<Long>(orderId ,HttpStatus.CREATED);

	}
	
	@GetMapping(value = "/getAll")
	public List<SalesOrder> getAllSalesOrder() {
		return getSalesOrderServiceImpl().getSalesOrder();
	}
	

	public SalesOrderServiceImpl getSalesOrderServiceImpl() {
		return salesOrderServiceImpl;
	}

	@Autowired
	public void setSalesOrderServiceImpl(SalesOrderServiceImpl salesOrderServiceImpl) {
		this.salesOrderServiceImpl = salesOrderServiceImpl;
	}
	
	
}
