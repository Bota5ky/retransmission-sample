package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flux")
public class FluxController {
    @Autowired
    private RemoteClient remoteClient;

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    Mono<Map<String, List<String>>> callFlux() {
        Enumeration<String> headerNames = request.getHeaderNames();
        HttpHeaders headers = new HttpHeaders();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.add(headerName, headerValue);
        }

        return remoteClient.call(headers);
    }
}
