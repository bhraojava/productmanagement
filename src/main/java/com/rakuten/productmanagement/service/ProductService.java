package com.rakuten.productmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.productmanagement.model.Product;
import com.rakuten.productmanagement.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Mono<Product> getProductById(String productId) {
		
		return productRepository.findById(productId);
	}

	
	public Flux<Product> getAllProducts() {
		
		return productRepository.findAll();
	}


	public Mono<Product> saveProduct(Product produt) {
		
		return productRepository.save(produt);
	}
}
