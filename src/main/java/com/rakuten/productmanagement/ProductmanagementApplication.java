package com.rakuten.productmanagement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.rakuten.productmanagement.model.Product;
import com.rakuten.productmanagement.repository.ProductRepository;
import com.rakuten.productmanagement.utils.Status;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
@ComponentScan(basePackages = "com.rakuten.productmanagement")
public class ProductmanagementApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductmanagementApplication.class, args);
	
	}


	@Override
	public void run(String... args) throws Exception {
		
		productRepository.deleteAll()
		.subscribe(null, null, () -> 
		productRepository.saveAll(prePopulatData())
		.subscribe(System.out::println));
	}
	
    private static List<Product> prePopulatData() {
		
		Product productOne = new Product(UUID.randomUUID().toString(), Instant.now().toEpochMilli(), Status.FULFILLED.getValue(), 20.0, 200.0,
				UUID.randomUUID().toString(), UUID.randomUUID().toString(), 20, "Product One Details");
		Product productTwo = new Product(UUID.randomUUID().toString(), Instant.now().toEpochMilli(), Status.FULFILLED.getValue(), 10.0, 100.0,
				UUID.randomUUID().toString(), UUID.randomUUID().toString(), 10, "Product Two Details");
		Product productThree = new Product(UUID.randomUUID().toString(), Instant.now().toEpochMilli(), Status.FULFILLED.getValue(), 30.0, 300.0,
				UUID.randomUUID().toString(), UUID.randomUUID().toString(), 30, "Product Three Details");
		List<Product> productList = new ArrayList<>();
		productList.add(productOne); 
		productList.add(productTwo);
		productList.add(productThree);
		
		log.info("Product List :" +  productList);
		return productList;
	}
}
	