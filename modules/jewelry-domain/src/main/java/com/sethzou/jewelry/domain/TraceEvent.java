package com.sethzou.jewelry.domain;

import java.time.Instant;

public record TraceEvent(
        JewelryId jewelryId,
        TraceEventType eventType,
        String actorOrgId,
        String payloadHash,
        Instant occurredAt
) {
}
