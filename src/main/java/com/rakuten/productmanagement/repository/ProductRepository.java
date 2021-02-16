package com.rakuten.productmanagement.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rakuten.productmanagement.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>{

}
