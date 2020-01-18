package com.qding.eyecloud.webflux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.qding.eyecloud.webflux.handler.AuthHandler;

@Configuration
public class AuthRouter {
	
	@Bean
	public RouterFunction<ServerResponse> helloXttblog(AuthHandler handler) {
		return RouterFunctions.route(
				RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
				handler::helloXttblog);
	}

	@Bean
	public RouterFunction<ServerResponse> helloFlux(AuthHandler handler) {
		return RouterFunctions.route(
				RequestPredicates.GET("/helloFlux").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
				handler::helloFlux);
	}
}
