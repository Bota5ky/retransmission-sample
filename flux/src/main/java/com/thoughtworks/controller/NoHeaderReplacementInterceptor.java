package com.thoughtworks.controller;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class NoHeaderReplacementInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.headers(template.request().headers());
    }
}
