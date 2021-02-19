package com.rakuten.productmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.rakuten.productmanagement.utils.ValidateHandler;

@Configuration
public class Router {


	private final MediaType json = MediaType.APPLICATION_JSON;
	
	@Bean
	public RouterFunction<ServerResponse> validateEndpoint(ValidateHandler handler) {

		return RouterFunctions.route(RequestPredicates.POST("/product/delete"), handler::validate);
		
	}
	
}
