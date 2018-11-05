package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.CustomerSOS;
import com.main.repository.SalesOrderCustomerRepository;

@Service
public class SalesOrderCustomerServiceImpl {

	private SalesOrderCustomerRepository salesOrderCustomerRepository;

	public Long createCustomerSOS(CustomerSOS customerSOS) {
		CustomerSOS customerSOSStatus = getSalesOrderCustomerRepository().saveAndFlush(customerSOS);
		return customerSOSStatus.getId();
	}

	public List<CustomerSOS> getSalesOrderCustomer() {
		return (List<CustomerSOS>) getSalesOrderCustomerRepository().findAll();
	}

	public SalesOrderCustomerRepository getSalesOrderCustomerRepository() {
		return salesOrderCustomerRepository;
	}

	@Autowired
	public void setSalesOrderCustomerRepository(SalesOrderCustomerRepository salesOrderCustomerRepository) {
		this.salesOrderCustomerRepository = salesOrderCustomerRepository;
	}

}
