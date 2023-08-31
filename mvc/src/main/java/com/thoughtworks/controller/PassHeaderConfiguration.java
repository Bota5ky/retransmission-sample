package com.thoughtworks.controller;

import org.springframework.context.annotation.Bean;

public class PassHeaderConfiguration {
    @Bean
    ServiceTokenHeaderInterceptor serviceTokenHeaderInterceptor() {
        return new ServiceTokenHeaderInterceptor();
    }
}
