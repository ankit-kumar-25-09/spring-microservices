package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.ShoppingCartRequest;
import com.model.ShoppingCartResponse;
import com.service.AppService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
@RequestMapping("/shoppingcart")

public class AppController {
	
	@Autowired
	private AppService service;
	
	@PostMapping("/{userId}/products")
	private ResponseEntity addproduct(@PathVariable Long userId,@RequestBody List<ShoppingCartRequest> reqprodList) {
		
		ShoppingCartResponse response = service.processAndSend(userId, reqprodList);
		return new ResponseEntity(response,HttpStatus.CREATED);
	}
	
	

}
