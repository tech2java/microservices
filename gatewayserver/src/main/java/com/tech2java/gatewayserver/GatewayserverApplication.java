package com.tech2java.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator tech2javaRouteConfig(RouteLocatorBuilder routeLocatorBuilder){

		return routeLocatorBuilder.routes()
				.route(p->p
						.path("/eazybank/accounts/**")
						.filters(f->f.rewritePath("/eazybank/accounts/(?<segment>.*)","/${segment}")
						.addResponseHeader("X-RESPONSE-TIME", LocalDateTime.now().toString()))
				.uri("lb://ACCOUNTS")).build();

	}
}
