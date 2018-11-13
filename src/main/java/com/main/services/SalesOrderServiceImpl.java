package com.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.entity.SalesOrder;
import com.main.repository.CreateOrderRepository;
import com.main.repository.SalesOrderCustomerRepository;
import com.main.util.ProductNotValidException;

@Service
public class SalesOrderServiceImpl {

	private CreateOrderRepository createOrderRepository;

	private SalesOrderCustomerRepository salesOrderCustomerRepository;

	@Value("${itemservices.chkname}")
	String resourceUrl;

	public Long createSalesOrder(SalesOrder salesOrder) {
		// TODO validate customer by verifying the table “customer_sos” with cust_id
		// Optional<CustomerSOS> customerSOS =
		// getSalesOrderCustomerRepository().findById(salesOrder.getCustId());
		if (getSalesOrderCustomerRepository().findById(salesOrder.getCustId()).isPresent()) {

		}
		// validate items by calling item service with item name
		SalesOrder salesOrderStatus = null;
		String Url = resourceUrl + salesOrder.getOrderLineItem().get(0).getItemName();
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Optional> response = restTemplate.getForEntity(Url , Optional.class);
		
		
		//Optional<Boolean> response = restTemplate.getForObject(Url,  Optional.class);
		if(response.getBody().get().equals(Boolean.TRUE)) {
			salesOrderStatus = getCreateOrderRepository().saveAndFlush(salesOrder);
		}else {
			System.out.println("------------------in else");
			throw new ProductNotValidException("Product name is not valid");
		}
		
		System.out.println(response.getBody().get().equals(Boolean.TRUE));
		
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

	public SalesOrderCustomerRepository getSalesOrderCustomerRepository() {
		return salesOrderCustomerRepository;
	}

	@Autowired
	public void setSalesOrderCustomerRepository(SalesOrderCustomerRepository salesOrderCustomerRepository) {
		this.salesOrderCustomerRepository = salesOrderCustomerRepository;
	}

}
