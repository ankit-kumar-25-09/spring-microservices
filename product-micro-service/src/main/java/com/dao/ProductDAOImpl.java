package com.dao;

import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repo.ProductRepo;

@Service
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	ProductRepo productRepo;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		Product addedProduct = productRepo.save(product);
		return addedProduct;
	}

	@Override
	public List<Product> loadProducts() {
		// TODO Auto-generated method stub
		return (List<Product>)productRepo.findAll();
	}

	@Override
	public List<Product> getByIds(List<Long> plist) {
		// TODO Auto-generated method stub
		return (List<Product>)productRepo.findAllById(plist);
	}

}
