package com.rakuten.productmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import com.rakuten.productmanagement.controller.ProductController;
import com.rakuten.productmanagement.model.Product;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

@ComponentScan(basePackages = "com.rakuten.productmanagement")
@EnableAutoConfiguration
@Log4j2
// @WebFluxTest(ProductController.class)
// @RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductController.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductmanagementApplicationTests {
	@Autowired
	WebTestClient webTestClient;
	WebClient testClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
            .build();
	@Test
	public void testAllProducts() {
		
		  Flux<Product> products = webTestClient .get() .uri("/product/all")
		  .accept(MediaType.APPLICATION_JSON) .exchange() .expectStatus().isOk() //
		  .expectHeader().valueEquals("content-type", "application/json")
		  .returnResult(Product.class).getResponseBody();
		 
		  products
		  .log()
		  .doOnNext(product -> {
			 assertEquals(1, product.getStatus());
		  })
		.subscribe();
		    
	
			/*
			 * testClient .get() .uri("/product/all") .accept(MediaType.APPLICATION_JSON)
			 * .retrieve() .bodyToFlux(Product.class) .log() .subscribe();
			 */
		    
 
	}

	@Test
	public void testOneProduct() {
		
		  Product firstProduct = webTestClient 
				  .get() .uri("/product/all")
				  .accept(MediaType.APPLICATION_JSON) .exchange() .expectStatus().isOk() //
				  .expectHeader().valueEquals("content-type", "application/json")
				  .returnResult(Product.class)
				  .getResponseBody()
				  .blockFirst();
		 
		  assertEquals(2, firstProduct.getStatus());		
		    
	
			/*
			 * testClient .get() .uri("/product/all") .accept(MediaType.APPLICATION_JSON)
			 * .retrieve() .bodyToFlux(Product.class) .log() .subscribe();
			 */
	}
}
