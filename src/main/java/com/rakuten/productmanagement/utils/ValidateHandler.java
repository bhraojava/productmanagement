package com.rakuten.productmanagement.utils;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rakuten.productmanagement.model.Product;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Component
public class ValidateHandler {

	private MediaType json = MediaType.APPLICATION_JSON;
	
	
	public Mono<ServerResponse> validate(ServerRequest request){
		
		String bodyData = request.bodyToMono(JSONPObject.class);
		
		
		
		log.info("************"+ bodyData);
		
		return ServerResponse.ok().contentType(json).bodyValue(request);
		
	}
	
}
