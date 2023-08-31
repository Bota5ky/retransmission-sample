package com.thoughtworks.controller;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class ServiceTokenHeaderInterceptor implements RequestInterceptor {
//    @Value("${spring.application.name}")
//    private String appName;
    public void apply(RequestTemplate template) {
        try {
            Map<String, String> map = Optional.ofNullable(MDC.getCopyOfContextMap()).orElse(Collections.emptyMap());
            var dealerId = getValueByKey(map, "x-dealer-id");
            template.header("x-dealer-id", dealerId);

            if ("abc".equals(dealerId)) {
                template.target("http://localhost:8080");
            } else {
                template.target("http://localhost:8081");
            }
        } catch (Exception e) {
            System.out.println("-----------------");
        }
    }

    private String getValueByKey(Map<String, String> map, String key) {
        return Optional.ofNullable(RequestUtils.getHeader(key)).orElse(map.get(key));
    }
}