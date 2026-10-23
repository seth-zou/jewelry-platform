package com.sethzou.jewelry.chainwriter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChainWriterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChainWriterApplication.class, args);
    }

    public String role() {
        return "asynchronous chain writer";
    }
}
