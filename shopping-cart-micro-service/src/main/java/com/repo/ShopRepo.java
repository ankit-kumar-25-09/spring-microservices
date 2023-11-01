package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.ShopCart;

@Repository 
public interface ShopRepo extends CrudRepository<ShopCart, Long>{

}
