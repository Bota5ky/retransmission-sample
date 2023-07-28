package com.thoughtworks;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("http://localhost:8088", r -> r
                .path("/flux")
                .uri("http://localhost:8081"))
            .route("http://localhost:8088", r -> r
                .path("/mvc")
                .uri("http://localhost:8082"))
            .build();
    }
}
