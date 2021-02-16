package com.rakuten.productmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.rakuten.productmanagement.controller.ProductController;

import lombok.extern.log4j.Log4j2;

@Log4j2
// @WebFluxTest(ProductController.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductmanagementApplicationTests {

	@Autowired
	private ProductController controller;

	WebTestClient testClient = WebTestClient.bindToController(controller).build();
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testAllProducts() {
		WebTestClient
		  .bindToServer()
		    .baseUrl("http://localhost:8080")
		    .build()
		    .get()
		    .uri("/product/all")
		  .exchange()
		    .expectStatus().isOk()
		    .expectHeader().valueEquals("content-type", "application/json")
		    .expectBody().jsonPath("quantity").isEqualTo("20");
	}
	
}
