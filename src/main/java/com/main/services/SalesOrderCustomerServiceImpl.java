package com.main.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.entity.CustomerSOS;
import com.main.repository.SalesOrderCustomerRepository;
import com.main.util.Customer;

@Service
public class SalesOrderCustomerServiceImpl {

	private SalesOrderCustomerRepository salesOrderCustomerRepository;

	@Value("${customer.service.getcust}")
	String custServiceUrl;

	@Autowired
	RestTemplate restTemplate;

	public Long createCustomerSOS(Customer cust) {
		String Url = custServiceUrl + cust.getCustId();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Customer> entity = new HttpEntity<Customer>(headers);
		// Customer Service Call
		Customer customer = restTemplate.exchange(Url, HttpMethod.GET, entity, Customer.class).getBody();
		CustomerSOS customerSOS = new CustomerSOS(customer.getCustId(), customer.getFirstName(), customer.getLastName(),
				customer.getEmailId());
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
