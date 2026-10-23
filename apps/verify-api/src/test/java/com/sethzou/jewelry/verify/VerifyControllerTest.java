package com.sethzou.jewelry.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VerifyControllerTest {
    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void returnsPlaceholderVerification() {
        Map<?, ?> response = restTemplate.getForObject("http://localhost:" + port + "/api/v1/verify/JWL-DEMO-0001", Map.class);
        assertThat(response.get("code")).isEqualTo("OK");
    }
}
