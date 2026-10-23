package com.sethzou.jewelry.business;

import com.sethzou.jewelry.common.ApiResponse;
import com.sethzou.jewelry.domain.JewelryId;
import com.sethzou.jewelry.domain.TraceEvent;
import com.sethzou.jewelry.domain.TraceEventType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
class BusinessHealthController {
    @GetMapping("/health")
    Map<String, String> health() {
        return Map.of("status", "UP", "service", "business-api");
    }

    @GetMapping("/api/v1/placeholder/trace-events")
    ApiResponse<List<TraceEvent>> placeholderEvents() {
        TraceEvent event = new TraceEvent(new JewelryId("JWL-DEMO-0001"), TraceEventType.REGISTERED, "demo-brand", "hash-placeholder", Instant.EPOCH);
        return ApiResponse.ok(List.of(event));
    }
}
