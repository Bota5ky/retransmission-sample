package com.thoughtworks.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
public class RemoteController {
    private static final List<String> FORWARDED_HEADER_NAMES = List.of("Forwarded", "X-Forwarded-Host",
        "X-Forwarded-Port", "X-Forwarded-Proto", "X-Forwarded-Prefix", "X-Forwarded-Ssl", "X-Forwarded-For");

    @GetMapping("/remote")
    public Map<String, List<String>> callRemote(HttpServletRequest request) {
        return initHeaders(request);
    }

    private static Map<String, List<String>> initHeaders(HttpServletRequest request) {
        Map<String, List<String>> headers = new LinkedCaseInsensitiveMap<>(Locale.ENGLISH);
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            if (!FORWARDED_HEADER_NAMES.contains(name)) {
                headers.put(name, Collections.list(request.getHeaders(name)));
            }
        }
        return headers;
    }
}
