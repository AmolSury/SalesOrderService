package com.main.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.main.util.Customer;

@FeignClient(name="customer-service")
public interface RemoteCallCustomerService {
	
	@RequestMapping(method=RequestMethod.GET, value = "/get/{id}")
	public Customer getCustomerById(@PathVariable("id") Long id);
	
}
