package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.CustomerSOS;
import com.main.services.SalesOrderCustomerServiceImpl;

@RestController
@RequestMapping("/sales-order-customer")
public class SalesOrderCustomerController {

	private SalesOrderCustomerServiceImpl SalesOrderCustomerServiceImpl;

	/*@GetMapping(value = "/{id}/create/{msg}")
	public ResponseEntity<Long> createCustomer(@PathVariable("id") Long id, @PathVariable("msg") String msg) {
		if (Optional.ofNullable(msg).get().equals("CustomerCreated")) {
			Long custId = getSalesOrderCustomerServiceImpl().createCustomerSOS(id);
			return new ResponseEntity<Long>(custId, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Long>(id, HttpStatus.BAD_REQUEST);
		}
	}*/

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
