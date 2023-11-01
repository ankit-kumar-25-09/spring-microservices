package com.controller; 

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ProductDAO;
import com.entity.Product;


@RestController
@RequestMapping("/products")
@RefreshScope
public class ProductController {
	
	@Value("${product.appname}")
	private String productName;
	
	@Autowired
	ProductDAO prodDAO;
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return prodDAO.addProduct(product);
	}
	@GetMapping("/loadproducts")
	public List<Product> showProducts(){
		return prodDAO.loadProducts();
	}
	
	@GetMapping("/loadproducts/{plist}")
	public List<Product> loadProductByIds(@PathVariable List<Long>plist){
		System.out.println(productName);
		return prodDAO.getByIds(plist);
	}
	
	
}
