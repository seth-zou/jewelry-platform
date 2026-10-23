package com.sethzou.jewelry.verify;

import com.sethzou.jewelry.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class VerifyController {
    @GetMapping("/health")
    Map<String, String> health() {
        return Map.of("status", "UP", "service", "verify-api");
    }

    @GetMapping("/api/v1/verify/{jewelryId}")
    ApiResponse<Map<String, String>> verify(@PathVariable String jewelryId) {
        return ApiResponse.ok(Map.of("jewelryId", jewelryId, "chainStatus", "PENDING_CHAIN", "result", "PLACEHOLDER"));
    }
}
