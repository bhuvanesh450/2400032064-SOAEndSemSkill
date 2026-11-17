package com.example.soa.service;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class GreetingService {
    public Map<String, Object> getGreeting(String name) {
        String safeName = (name == null || name.isBlank()) ? "SOA User" : name.trim();
        return Map.of(
                "service", "greeting-service",
                "message", "Hello, " + safeName + "! Your Java SOA REST service is running.",
                "timestamp", Instant.now().toString()
        );
    }

    public Map<String, String> getServiceInfo() {
        return Map.of(
                "application", "SOA REST Service",
                "architecture", "Service-Oriented Architecture",
                "technology", "Java 17 + Spring Boot",
                "database", "Not required"
        );
    }
}
