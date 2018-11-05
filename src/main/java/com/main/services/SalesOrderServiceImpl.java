package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.SalesOrder;
import com.main.repository.CreateOrderRepository;

@Service
public class SalesOrderServiceImpl {
	
	private CreateOrderRepository createOrderRepository;
	
	public Long createSalesOrder(SalesOrder salesOrder) {
		SalesOrder salesOrderStatus = getCreateOrderRepository().saveAndFlush(salesOrder);
		return salesOrderStatus.getId();
	}
	
	public List<SalesOrder> getSalesOrder() {
		return (List<SalesOrder>) getCreateOrderRepository().findAll();
	}

	public CreateOrderRepository getCreateOrderRepository() {
		return createOrderRepository;
	}

	@Autowired
	public void setCreateOrderRepository(CreateOrderRepository createOrderRepository) {
		this.createOrderRepository = createOrderRepository;
	}
	
}
