package com.thoughtworks.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "remote-service", url = "http://localhost:8080", configuration = PassHeaderConfiguration.class)
public interface RemoteClient {
    @GetMapping("/remote")
    Map<String, List<String>> call();
}
