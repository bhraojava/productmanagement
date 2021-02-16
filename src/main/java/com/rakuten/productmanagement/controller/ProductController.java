package com.rakuten.productmanagement.controller;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.productmanagement.model.Product;
import com.rakuten.productmanagement.service.ProductService;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/id/{productId}")
	public Mono<Product> getProductById(@PathVariable String productId) {
		try {
		log.info("Product Service By id " + productService.getProductById(productId));
		 return productService.getProductById(productId);
		}catch (Error e) {
			 throw new RuntimeErrorException(e, e.getMessage());
		}
	}

	
	@GetMapping("/all")
	public ResponseEntity<Flux<Product>> getAllProducts() {
		try {
		 return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
		}catch (Error e) {
			 throw new RuntimeErrorException(e, e.getMessage());
		}
	}
	
	
	@PostMapping("/save")
	public Mono<Product> saveProduct(@RequestBody Product produt) {
		try {
		 return productService.saveProduct(produt);
		}catch (Error e) {
			 throw new RuntimeErrorException(e, e.getMessage());
		}
	}
}
