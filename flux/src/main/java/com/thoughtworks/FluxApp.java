package com.thoughtworks;

import com.thoughtworks.controller.NoHeaderReplacementInterceptor;
import feign.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class FluxApp {
    public static void main(String[] args) {
        SpringApplication.run(FluxApp.class, args);
    }

    @Bean
    public HttpMessageConverters customConverters() {
        return new HttpMessageConverters();
    }

    @Bean
    public RequestInterceptor noHeaderReplacementInterceptor() {
        return new NoHeaderReplacementInterceptor();
    }
}