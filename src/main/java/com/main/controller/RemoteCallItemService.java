package com.main.controller;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="items-service")
public interface RemoteCallItemService {
	
	@RequestMapping(method=RequestMethod.GET, value = "/get")
	public Optional<Boolean> getProductName(@RequestParam("name") String name);
	
}
