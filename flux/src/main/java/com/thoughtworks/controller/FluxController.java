package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flux")
public class FluxController {
    @Autowired
    private RemoteClient remoteClient;

    @GetMapping
    Map<String, List<String>> callFlux(){
        return remoteClient.call();
    }
}
