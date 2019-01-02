package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.CustomerSOS;
import com.main.services.SalesOrderCustomerServiceImpl;

@RestController
public class SalesOrderCustomerController {

	private SalesOrderCustomerServiceImpl SalesOrderCustomerServiceImpl;

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
