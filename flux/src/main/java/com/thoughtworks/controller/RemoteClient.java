package com.thoughtworks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@ReactiveFeignClient(name = "remote-service", url = "http://localhost:8080")
public interface RemoteClient {
    @GetMapping("/remote")
    Mono<Map<String, List<String>>> call();
}
