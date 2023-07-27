package com.thoughtworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients
public class FluxApp {
    public static void main(String[] args) {
        SpringApplication.run(FluxApp.class, args);
    }

    @Bean
    public HttpMessageConverters customConverters() {
        return new HttpMessageConverters();
    }
}