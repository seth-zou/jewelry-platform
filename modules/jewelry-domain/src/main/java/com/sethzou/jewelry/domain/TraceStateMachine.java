package com.sethzou.jewelry.domain;

public final class TraceStateMachine {
    public AssetStatus apply(AssetStatus current, TraceEventType eventType) {
        return switch (eventType) {
            case REGISTERED -> AssetStatus.REGISTERED;
            case CERTIFIED -> require(current, AssetStatus.REGISTERED, AssetStatus.CERTIFIED);
            case STORED -> require(current, AssetStatus.CERTIFIED, AssetStatus.IN_STOCK);
            case SHIPPED -> require(current, AssetStatus.IN_STOCK, AssetStatus.IN_TRANSIT);
            case RECEIVED -> require(current, AssetStatus.IN_TRANSIT, AssetStatus.DEALER_RECEIVED);
            case SOLD -> require(current, AssetStatus.DEALER_RECEIVED, AssetStatus.SOLD);
            case AFTERSALE_REQUESTED -> require(current, AssetStatus.SOLD, AssetStatus.AFTERSALE);
            case AFTERSALE_COMPLETED -> require(current, AssetStatus.AFTERSALE, AssetStatus.SOLD);
            case RESOLD -> require(current, AssetStatus.SOLD, AssetStatus.RESOLD);
            case REVOKED -> AssetStatus.REVOKED;
        };
    }

    private AssetStatus require(AssetStatus current, AssetStatus expected, AssetStatus next) {
        if (current != expected) {
            throw new IllegalStateException("expected " + expected + " but was " + current);
        }
        return next;
    }
}
