package com.sethzou.jewelry.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrationWorkerApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntegrationWorkerApplication.class, args);
    }

    public String role() {
        return "external event integration worker";
    }
}
