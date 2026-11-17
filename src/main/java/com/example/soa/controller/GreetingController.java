package com.example.soa.controller;

import com.example.soa.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public Map<String, Object> hello(
            @RequestParam(defaultValue = "SOA User") String name) {
        return greetingService.getGreeting(name);
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return greetingService.getServiceInfo();
    }
}
