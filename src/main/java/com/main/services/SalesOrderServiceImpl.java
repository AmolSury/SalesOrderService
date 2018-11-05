package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.CustomerSOS;
import com.main.entity.SalesOrder;
import com.main.repository.CreateOrderRepository;
import com.main.repository.SalesOrderCustomerRepository;

@Service
public class SalesOrderServiceImpl {
	
	private CreateOrderRepository createOrderRepository;
	
	private SalesOrderCustomerRepository salesOrderCustomerRepository;
	
	public Long createSalesOrder(SalesOrder salesOrder) {
		SalesOrder salesOrderStatus = getCreateOrderRepository().saveAndFlush(salesOrder);
		return salesOrderStatus.getId();
	}

	public Long createCustomerSOS(CustomerSOS customerSOS) {
		CustomerSOS customerSOSStatus = getSalesOrderCustomerRepository().saveAndFlush(customerSOS);
		return customerSOSStatus.getCustId();
	}
	
	public List<SalesOrder> getSalesOrder() {
		return (List<SalesOrder>) getCreateOrderRepository().findAll();
	}
	
	public List<SalesOrder> getSalesOrderCustomer() {
		return (List<SalesOrder>) getCreateOrderRepository().findAll();
	}
	

	public CreateOrderRepository getCreateOrderRepository() {
		return createOrderRepository;
	}

	public SalesOrderCustomerRepository getSalesOrderCustomerRepository() {
		return salesOrderCustomerRepository;
	}

	@Autowired
	public void setSalesOrderCustomerRepository(SalesOrderCustomerRepository salesOrderCustomerRepository) {
		this.salesOrderCustomerRepository = salesOrderCustomerRepository;
	}

	@Autowired
	public void setCreateOrderRepository(CreateOrderRepository createOrderRepository) {
		this.createOrderRepository = createOrderRepository;
	}
	
}
