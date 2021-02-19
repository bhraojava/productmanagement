package com.rakuten.productmanagement.controller;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

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
	
	@GetMapping("/find/id/{productId}")
	public Mono<Product> getProductById(@Valid @PathVariable String productId) {
		
		log.info("Product Service By id " + productService.getProductById(productId));
		 return productService.getProductById(productId);
		
	}

	
	@GetMapping("/all")
	public Flux<Product> getAllProducts() {
		 return productService.getAllProducts();
	}
	
	
	@PostMapping("/save")
	public Mono<Product> saveProduct(@Valid @RequestBody Product produt) {
		
		 return productService.saveProduct(produt);
		
	}
	
	@DeleteMapping("/delete/id/{productId}")
	public Mono<Void> deleteProductById(@Valid @PathVariable String productId) {
		
		log.info("Product Service By id " + productService.deleteProductById(productId));
		 return productService.deleteProductById(productId);
		
	}
	
	
	public Mono<ServerResponse> deleteByProduct() {
		
		return null;
	}
	
	
	  
}
