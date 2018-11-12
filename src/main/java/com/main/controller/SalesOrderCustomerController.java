package com.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.CustomerSOS;
import com.main.services.SalesOrderCustomerServiceImpl;


@RestController
@RequestMapping("/sales-order-customer")
public class SalesOrderCustomerController {

	private SalesOrderCustomerServiceImpl SalesOrderCustomerServiceImpl;
	
	@PostMapping(value = "/create")
	public ResponseEntity<Long> createCustomer(@RequestBody @Valid CustomerSOS customerSOS) {
		
		Long orderId = getSalesOrderCustomerServiceImpl().createCustomerSOS(customerSOS);	
		return new ResponseEntity<Long>(orderId ,HttpStatus.CREATED);

	}
	
	@GetMapping(value = "/get-all")
	public List<CustomerSOS> getAllCustomerSOS() {
		return getSalesOrderCustomerServiceImpl().getSalesOrderCustomer();
	}

	public SalesOrderCustomerServiceImpl getSalesOrderCustomerServiceImpl() {
		return SalesOrderCustomerServiceImpl;
	}
	
	@Autowired
	public void setSalesOrderCustomerServiceImpl(SalesOrderCustomerServiceImpl salesOrderCustomerServiceImpl) {
		SalesOrderCustomerServiceImpl = salesOrderCustomerServiceImpl;
	}

	
}
