package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.entity.ShopCart;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Product;
import com.model.ShoppingCartRequest;
import com.model.ShoppingCartResponse;
import com.repo.ShopRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AppService {
	
	@Autowired
	@Qualifier("webclient")
	private WebClient.Builder builder;
	
	@Autowired
	private ShopRepo shopRepo;
	@CircuitBreaker(fallbackMethod="fallbackMethod", name = "cb")
	public ShoppingCartResponse processAndSend(Long userId,List<ShoppingCartRequest> shoppingCartRequests) {
		ObjectMapper mapper = new ObjectMapper();
		String productServiceURL = "http://product-service/products/loadproducts/"+shoppingCartRequests.stream()
		.map(e->String.valueOf(e.getProductId())).collect(Collectors.joining(","));
		
		List<Product> productServiceList= builder.build()
				.get()
				.uri(productServiceURL)
				.retrieve()
				.bodyToFlux(Product.class)
				.collectList()
				.block();
		System.out.println(productServiceURL);
		System.out.println(productServiceList);
		//calculate the total cost
		final Double [] totalCosts = {0.0};
		productServiceList.forEach(psl->{
			shoppingCartRequests.forEach(cr->{
				if(psl.getProductId() == cr.getProductId()) {
					psl.setQuantity(cr.getQuantity());
					totalCosts[0] = totalCosts[0]+psl.getPrice()*cr.getQuantity();
				}
			});
		});
		
		ShopCart cart=null;
		try {
			cart = ShopCart.builder()
					.userId(userId)
					.cartId((long)(Math.random()*Math.pow(10, 10)))
					.totalItems(productServiceList.size())
					.totalCosts(totalCosts[0])
					.products(mapper.writeValueAsString(productServiceList))
					.build();
			cart = shopRepo.save(cart);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		ShoppingCartResponse res = ShoppingCartResponse.builder()
				.cartId(cart.getCartId())
				.products(productServiceList)
				.totalCosts(totalCosts[0])
				.userId(userId)
				.totalItems(cart.getTotalItems())
				.build();
		return res;
	}
	
	public ShoppingCartResponse fallbackMethod() {
		System.out.println("shouryan ki wajah se error");
		return ShoppingCartResponse.builder()
				.cartId((long)-1)
				.build();
	}
	
	
}
